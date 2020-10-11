package com.somecompany.demorestaurants;

public final class Constants {

  public static final String BASE_PATH = "http://localhost:8080/api/v1";
  public static final String TESTFAIL_BASE_PATH = BASE_PATH + "/" + "testfail";
  public static final String RESTAURANTS_BASE_PATH = BASE_PATH + "/" + "restaurants";

  public static final String SELF_REL = "self";

  public static final String POST_TYPE = "POST";
  public static final String PUT_TYPE = "PUT";
  public static final String DELETE_TYPE = "DELETE";

  public static final Long STUB_RESTAURANT_ID = 1L;
  public static final Long STUB_RESTAURANT_NON_EXISTING_ID = -1L;
  public static final String STUB_RESTAURANT_NAME = "Al Restoranto";
  public static final String STUB_RESTAURANT_DESCRIPTION = "Fine italian and german cuisines restaurant in Rome";
  public static final String STUB_RESTAURANT_ADDRESS = "Italy, Roma, Piazzo di Napoli 15";


  private Constants() {
    throw new IllegalStateException();
  }

}
