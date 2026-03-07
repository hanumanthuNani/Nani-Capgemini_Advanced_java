package com.restaurantapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class RestaurantDTO {

    @NotBlank(message = "Restaurant name cannot be empty")
    private String name;

    @NotBlank(message = "Location cannot be empty")
    private String location;

    @Positive(message = "Rating must be positive")
    private double rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}