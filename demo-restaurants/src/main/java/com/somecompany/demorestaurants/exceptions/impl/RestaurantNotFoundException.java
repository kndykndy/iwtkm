package com.somecompany.demorestaurants.exceptions.impl;

public class RestaurantNotFoundException
    extends RuntimeException {

  public RestaurantNotFoundException(final String message) {
    super(message);
  }

  public RestaurantNotFoundException(final long id) {
    this(String.format("Restaurant with id=%d not found.", id));
  }

}
