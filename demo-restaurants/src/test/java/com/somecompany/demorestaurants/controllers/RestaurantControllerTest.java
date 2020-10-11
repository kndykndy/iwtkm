package com.somecompany.demorestaurants.controllers;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import com.somecompany.demorestaurants.Constants;
import com.somecompany.demorestaurants.exceptions.GlobalExceptionHandler;
import com.somecompany.demorestaurants.model.Restaurant;
import com.somecompany.demorestaurants.model.Restaurant.Cuisine;
import com.somecompany.demorestaurants.repositories.RestaurantRepository;
import com.somecompany.demorestaurants.services.RestaurantService;
import java.util.Collections;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private RestaurantRepository restaurantRepository;
  @MockBean
  private RestaurantService restaurantService;

  private Restaurant stubRestaurant;


  @Before
  public void setup() {
    mockMvc = MockMvcBuilders
        .standaloneSetup(new RestaurantController(restaurantRepository, restaurantService))
        .setControllerAdvice(new GlobalExceptionHandler())
        .build();

    stubRestaurant = new Restaurant(
        Constants.STUB_RESTAURANT_NAME,
        Constants.STUB_RESTAURANT_DESCRIPTION,
        Constants.STUB_RESTAURANT_ADDRESS);
    stubRestaurant.setId(Constants.STUB_RESTAURANT_ID);
    stubRestaurant.setCuisines(Sets.newHashSet(Cuisine.ITALIAN, Cuisine.GERMAN));
  }

  @Test
  public void testCreateRestaurant() throws Exception {
    given(restaurantRepository.save(any(Restaurant.class))).willReturn(stubRestaurant);

    final ResultActions result =
        mockMvc.perform(
            post(Constants.RESTAURANTS_BASE_PATH)
                .content(objectMapper.writeValueAsBytes(stubRestaurant))
                .contentType(MediaType.APPLICATION_JSON_VALUE));
    result.andExpect(status().isCreated())
        .andExpect(header()
            .string("location", Constants.RESTAURANTS_BASE_PATH + "/" + stubRestaurant.getId()));
    verifyRestaurant(result);
    verifyHateoasForRestaurant(result, "");
  }

  @Test
  public void testCreateRestaurant_400() throws Exception {
    stubRestaurant.setDescription(null); // allowed
    stubRestaurant.setCuisines(null); // allowed
    stubRestaurant.setAddress(null); // not allowed, required

    given(restaurantRepository.save(any(Restaurant.class))).willReturn(stubRestaurant);

    final ResultActions result =
        mockMvc.perform(
            post(Constants.RESTAURANTS_BASE_PATH)
                .content(objectMapper.writeValueAsBytes(stubRestaurant))
                .contentType(MediaType.APPLICATION_JSON_VALUE));
    result.andExpect(status().isBadRequest());
  }

  @Test
  public void testFindAllRestaurants() throws Exception {
    given(restaurantRepository.findAll()).willReturn(Collections.singletonList(stubRestaurant));

    final ResultActions result = mockMvc.perform(get(Constants.RESTAURANTS_BASE_PATH));
    result.andExpect(status().isOk());

    verifyHateoasForRestaurant(result, "content[0].");
    verifyHateoasForRestaurantsCommon(result);
  }

  @Test
  public void testFindById() throws Exception {
    given(restaurantRepository.findById(Constants.STUB_RESTAURANT_ID))
        .willReturn(Optional.of(stubRestaurant));

    final ResultActions result = mockMvc.perform(
        get(Constants.RESTAURANTS_BASE_PATH + "/" + stubRestaurant.getId()));
    result.andExpect(status().isOk());

    verifyRestaurant(result);
    verifyHateoasForRestaurant(result, "");
  }

  @Test
  public void testFindById_404() throws Exception {
    given(restaurantRepository.findById(Constants.STUB_RESTAURANT_NON_EXISTING_ID))
        .willReturn(Optional.empty());

    final ResultActions result = mockMvc.perform(
        get(Constants.RESTAURANTS_BASE_PATH
            + "/" + Constants.STUB_RESTAURANT_NON_EXISTING_ID));
    result.andExpect(status().isNotFound());
  }

  @Test
  public void testFindRestaurantByAddress_400() throws Exception {
    given(restaurantRepository.findByAddress(Constants.STUB_RESTAURANT_ADDRESS))
        .willReturn(Optional.empty());

    final ResultActions result = mockMvc.perform(
        get(Constants.RESTAURANTS_BASE_PATH + "/findByAddressAsync"));
    result.andExpect(status().isBadRequest());
  }

  @Test
  public void testFindRestaurantByAddress_404() throws Exception {
    given(restaurantRepository.findByAddress("Some unknown address"))
        .willReturn(Optional.empty());

    final ResultActions result = mockMvc.perform(
        get(Constants.RESTAURANTS_BASE_PATH + "/findByAddressAsync")
            .param("address", "Some unknown address"));
    result.andExpect(status().isNotFound());
  }

  @Test
  public void testUpdateRestaurant() throws Exception {
    given(restaurantRepository.findById(Constants.STUB_RESTAURANT_ID))
        .willReturn(Optional.of(stubRestaurant));

    final ResultActions result = mockMvc.perform(
        put(Constants.RESTAURANTS_BASE_PATH + "/" + stubRestaurant.getId())
            .content(objectMapper.writeValueAsBytes(stubRestaurant))
            .contentType(MediaType.APPLICATION_JSON_VALUE));
    result.andExpect(status().isNoContent());
  }

  @Test
  public void testUpdateRestaurant_400() throws Exception {
    stubRestaurant.setDescription(null); // allowed
    stubRestaurant.setCuisines(null); // allowed
    stubRestaurant.setAddress(null); // not allowed, required

    given(restaurantRepository.save(any(Restaurant.class))).willReturn(stubRestaurant);

    final ResultActions result = mockMvc.perform(
        put(Constants.RESTAURANTS_BASE_PATH + "/" + stubRestaurant.getId())
            .content(objectMapper.writeValueAsBytes(stubRestaurant))
            .contentType(MediaType.APPLICATION_JSON_VALUE));
    result.andExpect(status().isBadRequest());
  }

  @Test
  public void testUpdateRestaurant_404() throws Exception {
    given(restaurantRepository.findById(Constants.STUB_RESTAURANT_NON_EXISTING_ID))
        .willReturn(Optional.empty());

    final ResultActions result = mockMvc.perform(
        put(Constants.RESTAURANTS_BASE_PATH + "/" + Constants.STUB_RESTAURANT_NON_EXISTING_ID)
            .content(objectMapper.writeValueAsBytes(stubRestaurant))
            .contentType(MediaType.APPLICATION_JSON_VALUE));
    result.andExpect(status().isNotFound());
  }

  @Test
  public void testDeleteRestaurant() throws Exception {
    given(restaurantRepository.findById(Constants.STUB_RESTAURANT_ID))
        .willReturn(Optional.of(stubRestaurant));

    final ResultActions result = mockMvc.perform(
        delete(Constants.RESTAURANTS_BASE_PATH + "/" + stubRestaurant.getId()));
    result.andExpect(status().isNoContent());
  }

  @Test
  public void testDeleteRestaurant_404() throws Exception {
    given(restaurantRepository.findById(Constants.STUB_RESTAURANT_NON_EXISTING_ID))
        .willReturn(Optional.empty());

    final ResultActions result = mockMvc.perform(
        delete(Constants.RESTAURANTS_BASE_PATH
            + "/" + Constants.STUB_RESTAURANT_NON_EXISTING_ID));
    result.andExpect(status().isNotFound());
  }

  // Routines

  private void verifyRestaurant(ResultActions result) throws Exception {
    result.andExpect(
        MockMvcResultMatchers.jsonPath("id",
            is(Constants.STUB_RESTAURANT_ID.intValue())))
        .andExpect(jsonPath("name", is(Constants.STUB_RESTAURANT_NAME)))
        .andExpect(jsonPath("description", is(Constants.STUB_RESTAURANT_DESCRIPTION)))
        .andExpect(jsonPath("address", is(Constants.STUB_RESTAURANT_ADDRESS)));
  }

  private void verifyHateoasForRestaurant(ResultActions result, String jsonPrefix)
      throws Exception {
    result.andExpect(MockMvcResultMatchers
        .jsonPath(jsonPrefix + "links[0].rel",
            is(Constants.SELF_REL)))
        .andExpect(jsonPath(jsonPrefix + "links[0].href",
            is(Constants.RESTAURANTS_BASE_PATH + "/" + stubRestaurant.getId())))
        .andExpect(jsonPath(jsonPrefix + "links[1].rel",
            is("update restaurant")))
        .andExpect(jsonPath(jsonPrefix + "links[1].href",
            is(Constants.RESTAURANTS_BASE_PATH + "/" + stubRestaurant.getId())))
        .andExpect(jsonPath(jsonPrefix + "links[1].type",
            is(Constants.PUT_TYPE)))
        .andExpect(jsonPath(jsonPrefix + "links[2].rel",
            is("delete restaurant")))
        .andExpect(jsonPath(jsonPrefix + "links[2].href",
            is(Constants.RESTAURANTS_BASE_PATH + "/" + stubRestaurant.getId())))
        .andExpect(MockMvcResultMatchers.jsonPath(jsonPrefix + "links[2].type",
            is(Constants.DELETE_TYPE)));
  }

  private void verifyHateoasForRestaurantsCommon(ResultActions result) throws Exception {
    result.andExpect(MockMvcResultMatchers.jsonPath("links[0].rel",
        is(Constants.SELF_REL)))
        .andExpect(jsonPath("links[0].href", is(Constants.RESTAURANTS_BASE_PATH)))
        .andExpect(jsonPath("links[1].rel", is("create new restaurant")))
        .andExpect(jsonPath("links[1].href", is(Constants.RESTAURANTS_BASE_PATH)))
        .andExpect(jsonPath("links[1].type", is(Constants.POST_TYPE)));
  }

}
