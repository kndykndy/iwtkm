package com.somecompany.demorestaurants.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.google.common.collect.Lists;
import com.somecompany.demorestaurants.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
    path = Constants.ROOT_API_ENDPOINT,
    produces = MediaTypes.HAL_JSON_VALUE)
@Api(description = "Miscellaneous operations")
public class RootController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);


  /**
   * Retrieves all available root endpoints.
   */
  @ApiOperation(value = "Retrieves all available root endpoints, HATEOAS")
  @GetMapping
  public ResponseEntity<ResourceSupport> getEndpoints() {
    final ResourceSupport resourceSupport = new ResourceSupport();
    resourceSupport.add(linkTo(methodOn(RootController.class).getEndpoints()).withSelfRel());
    resourceSupport.add(createSupportLinks());

    LOGGER.info("RootController: Getting available endpoints.");

    return ResponseEntity.ok(resourceSupport);
  }

  /**
   * Visualizes general exception handler.
   */
  @ApiOperation(value = "Visualizes general exception handler")
  @GetMapping("/testfail")
  public ResponseEntity<?> failMethod() {
    throw new IllegalStateException("Test fail 01 method call");
  }

  // Routines

  private static List<Link> createSupportLinks() {
    return Lists.newArrayList(
        linkTo(methodOn(RestaurantController.class).findAllRestaurants())
            .withRel("list all restaurants"),
        linkTo(methodOn(RestaurantController.class).createRestaurant(null))
            .withRel("create restaurant").withType("POST"));
  }

}
