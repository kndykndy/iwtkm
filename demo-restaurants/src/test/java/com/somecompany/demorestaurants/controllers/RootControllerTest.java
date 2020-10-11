package com.somecompany.demorestaurants.controllers;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.somecompany.demorestaurants.Constants;
import com.somecompany.demorestaurants.exceptions.GlobalExceptionHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(RootController.class)
public class RootControllerTest {

  private MockMvc mockMvc;


  @Before
  public void setup() {
    mockMvc = MockMvcBuilders
        .standaloneSetup(new RootController())
        .setControllerAdvice(new GlobalExceptionHandler())
        .build();
  }

  @Test
  public void testGetEndpoints() throws Exception {
    final ResultActions result = mockMvc.perform(get(Constants.BASE_PATH));
    result.andExpect(status().isOk());
    result.andExpect(MockMvcResultMatchers.jsonPath(
        "links[0].rel", is(Constants.SELF_REL)))
        .andExpect(jsonPath("links[0].href", is(Constants.BASE_PATH)))
        .andExpect(jsonPath("links[1].rel", is("list all restaurants")))
        .andExpect(jsonPath("links[1].href", is(Constants.RESTAURANTS_BASE_PATH)))
        .andExpect(jsonPath("links[2].rel", is("create restaurant")))
        .andExpect(jsonPath("links[2].href", is(Constants.RESTAURANTS_BASE_PATH)))
        .andExpect(MockMvcResultMatchers.jsonPath(
            "links[2].type", is(Constants.POST_TYPE)));
  }

  @Test
  public void testFailMethod() throws Exception {
    final ResultActions result = mockMvc.perform(get(Constants.TESTFAIL_BASE_PATH));
    result.andExpect(status().isInternalServerError());
    result.andExpect(jsonPath("details", is("Test fail 01 method call")));
  }

}
