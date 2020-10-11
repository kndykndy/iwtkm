package com.somecompany.demorestaurants.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.somecompany.demorestaurants.Constants;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = Constants.DEMO_RESTAURANTS_SCHEMA, name = Constants.RESTAURANTS_TABLE)
public class Restaurant {

  public enum Cuisine {
    @JsonProperty("ITALIAN") ITALIAN,
    @JsonProperty("AMERICAN") AMERICAN,
    @JsonProperty("GERMAN") GERMAN,
    @JsonProperty("GEORGIAN") GEORGIAN,
    @JsonProperty("JAPANESE") JAPANESE
  }


  @ApiModelProperty("Generated Id")
  @Id
  @GeneratedValue
  private Long id;

  @ApiModelProperty(value = "Restaurant name", required = true)
  @NotNull(message = "Restaurant name must be provided!")
  @NotBlank(message = "Restaurant name must not be blank!")
  private String name;

  @ApiModelProperty("Restaurant description")
  @JsonInclude(Include.NON_NULL)
  private String description;

  @ApiModelProperty(value = "Restaurant address", required = true)
  @NotNull(message = "Restaurant address must be provided!")
  @NotBlank(message = "Restaurant address must not be blank!")
  private String address;

  @ApiModelProperty("Served cuisines, multiple")
  @ElementCollection(targetClass = Cuisine.class, fetch = FetchType.EAGER)
  @CollectionTable(
      name = Constants.CUISINES_TABLE, schema = Constants.DEMO_RESTAURANTS_SCHEMA,
      joinColumns = @JoinColumn(name = "restaurant_id"))
  @Enumerated(EnumType.STRING)
  @JsonInclude(Include.NON_EMPTY)
  private Set<Cuisine> cuisines;


  /**
   * No-arg constructor needed by persistence framework.
   */
  public Restaurant() {
  }

  public Restaurant(String name, String description, String address) {
    this.name = name;
    this.description = description;
    this.address = address;
  }

  public Restaurant(Restaurant restaurant) {
    this(restaurant.getName(), restaurant.getDescription(), restaurant.getAddress());

    final Set<Cuisine> otherCuisines = restaurant.getCuisines();
    if (otherCuisines != null && !otherCuisines.isEmpty()) {
      this.cuisines = Sets.newHashSet(otherCuisines);
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Set<Cuisine> getCuisines() {
    return cuisines;
  }

  public void setCuisines(Set<Cuisine> cuisines) {
    this.cuisines = cuisines;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Restaurant that = (Restaurant) o;
    return Objects.equal(id, that.id) &&
        Objects.equal(name, that.name) &&
        Objects.equal(description, that.description) &&
        Objects.equal(address, that.address) &&
        Objects.equal(cuisines, that.cuisines);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, name, description, address, cuisines);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("name", name)
        .add("description", truncate(description, 20))
        .add("address", truncate(address, 15))
        .add("cuisines", cuisines)
        .toString();
  }

  private static String truncate(final String str, final int maxLength) {
    return Strings.isNullOrEmpty(str) || maxLength >= str.length()
        ? str
        : str.substring(0, Math.min(maxLength, str.length()));
  }

}
