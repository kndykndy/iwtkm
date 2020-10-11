package com.somecompany.demorestaurants.repositories;

import com.somecompany.demorestaurants.model.Restaurant;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RestaurantRepository
    extends CrudRepository<Restaurant, Long> {

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  Optional<Restaurant> findByAddress(String address);

}
