package com.somecompany.demorestaurants.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.somecompany.demorestaurants.Constants;
import com.somecompany.demorestaurants.exceptions.impl.RestaurantNotFoundException;
import com.somecompany.demorestaurants.model.Restaurant;
import com.somecompany.demorestaurants.repositories.RestaurantRepository;
import com.somecompany.demorestaurants.services.RestaurantService;
import io.swagger.annotations.ApiOperation;
import java.net.URI;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(
    path = Constants.RESTAURANTS_API_ENDPOINT,
    produces = MediaTypes.HAL_JSON_VALUE)
public class RestaurantController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

  @Autowired
  private final RestaurantRepository restaurantRepository;

  @Autowired
  private final RestaurantService restaurantService;


  public RestaurantController(
      final RestaurantRepository restaurantRepository,
      final RestaurantService restaurantService) {

    this.restaurantRepository = restaurantRepository;
    this.restaurantService = restaurantService;
  }

  /**
   * Creates restaurant.
   */
  @ApiOperation(value = "Retrieves all restaurants, HATEOAS")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Resource<Restaurant>> createRestaurant(
      @Valid @RequestBody final Restaurant restaurant) {

    final Restaurant newRestaurant = restaurantRepository.save(new Restaurant(restaurant));

    final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(newRestaurant.getId()).toUri();

    LOGGER.info("RestaurantController: New restaurant was created: {}", newRestaurant);

    return ResponseEntity.created(location).body(createRestaurantResource(newRestaurant));
  }

  /**
   * Retrieves all restaurants.
   */
  @ApiOperation(value = "Retrieves all restaurants, HATEOAS")
  @GetMapping
  public ResponseEntity<Resources<Resource<Restaurant>>> findAllRestaurants() {
    LOGGER.debug("RestaurantController: Searching for all restaurants.");

    return ResponseEntity.ok(
        new Resources<>(
            StreamSupport.stream(restaurantRepository.findAll().spliterator(), false)
                .map(RestaurantController::createRestaurantResource)
                .collect(Collectors.toList()),
            createSupportLinks()));
  }

  /**
   * Searches for & retrieves a restaurant by its id.
   */
  @ApiOperation(value = "Searches for & retrieves a restaurant by its id, HATEOAS")
  @GetMapping("/{id}")
  public ResponseEntity<Resource<Restaurant>> findRestaurantById(
      @PathVariable final long id) {

    LOGGER.debug("RestaurantController: Searching for restaurant with id={}", id);

    return restaurantRepository.findById(id)
        .map(restaurant -> {
          LOGGER.debug("RestaurantController: Restaurant found: {}", restaurant);
          return ResponseEntity.ok(createRestaurantResource(restaurant));
        })
        .orElseThrow(() -> new RestaurantNotFoundException(id));
  }

  /**
   * Searches for & retrieves a restaurant by its address.
   * Done for demonstrational purposes of asynchronous functionality.
   */
  @ApiOperation(value = "Searches for & retrieves a restaurant by its address, HATEOAS")
  @GetMapping("/findByAddressAsync")
  public ResponseEntity<Resource<Restaurant>> findRestaurantByAddress(
      @RequestParam(value = "address") String address) {

    LOGGER.debug("RestaurantController: Searching for restaurant by address={}", address);

    return restaurantRepository.findByAddress(address)
        .map(restaurant -> {
          CompletableFuture
              .allOf(
                  restaurantService.longRunningMethod(),
                  restaurantService.longRunningMethod(),
                  restaurantService.longRunningMethod())
              .join();

          LOGGER.debug("RestaurantController: Restaurant found: {}", restaurant);
          return ResponseEntity.ok(createRestaurantResource(restaurant));
        })
        .orElseThrow(
            () -> new RestaurantNotFoundException("Restaurant not found with address: " + address));
  }

  /**
   * Updates restaurant info.
   */
  @ApiOperation(value = "Updates restaurant info, HATEOAS")
  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Resource<Restaurant>> updateRestaurant(
      @PathVariable final long id,
      @Valid @RequestBody Restaurant restaurant) {

    LOGGER.debug("RestaurantController: Attempting to update restaurant with id={} "
        + "and update it with: {}.", id, restaurant);

    final Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
    if (restaurantOptional.isPresent()) {
      final Restaurant newRestaurant = new Restaurant(restaurant);
      newRestaurant.setId(id);
      restaurantRepository.save(newRestaurant);

      LOGGER.info("RestaurantController: Updated restaurant with id={}: {}", id, restaurant);

      return ResponseEntity.noContent().build();
    } else {
      throw new RestaurantNotFoundException(id);
    }
  }

  /**
   * Deletes restaurant.
   */
  @ApiOperation(value = "Deletes restaurant")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteRestaurant(@PathVariable final long id) {
    LOGGER.debug("RestaurantController: Attempting to delete restaurant with id={}", id);

    return restaurantRepository.findById(id)
        .map(restaurant -> {
          restaurantRepository.delete(restaurant);

          LOGGER.info("RestaurantController: Restaurant with id={} was deleted.",
              restaurant.getId());

          return ResponseEntity.noContent().build();
        })
        .orElseThrow(() -> new RestaurantNotFoundException(id));
  }

  // Routines

  private static Resource<Restaurant> createRestaurantResource(final Restaurant restaurant) {
    final Long restaurantId = restaurant.getId();

    return new Resource<>(
        restaurant,
        linkTo(methodOn(RestaurantController.class).findRestaurantById(restaurantId))
            .withSelfRel(),
        linkTo(methodOn(RestaurantController.class).updateRestaurant(restaurantId, restaurant))
            .withRel("update restaurant").withType("PUT"),
        linkTo(methodOn(RestaurantController.class).deleteRestaurant(restaurantId))
            .withRel("delete restaurant").withType("DELETE"));
  }

  private static Link[] createSupportLinks() {
    return new Link[]{
        linkTo(methodOn(RestaurantController.class).findAllRestaurants()).withSelfRel(),
        linkTo(methodOn(RestaurantController.class).createRestaurant(null))
            .withRel("create new restaurant").withType("POST")
    };
  }

}
