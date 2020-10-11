package com.somecompany.demorestaurants;

public final class Constants {

  public static final String DEMO_RESTAURANTS_SCHEMA = "demorestaurants";

  public static final String RESTAURANTS_TABLE = "restaurants";
  public static final String CUISINES_TABLE = "cuisines";

  public static final String ROOT_API_ENDPOINT = "/api/v1";
  public static final String RESTAURANTS_API_ENDPOINT = ROOT_API_ENDPOINT + '/' + "restaurants";


  private Constants() {
    throw new IllegalStateException();
  }

}
