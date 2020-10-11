package com.somecompany.demorestaurants.services;

import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);


  @Async
  public CompletableFuture<Boolean> longRunningMethod() {
    LOGGER.debug("RestaurantService: Running long method.");

    try {
      Thread.sleep(5000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return CompletableFuture.completedFuture(true);
  }

}
