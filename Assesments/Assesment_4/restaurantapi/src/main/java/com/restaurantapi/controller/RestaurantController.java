package com.restaurantapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantapi.dto.RestaurantDTO;
import com.restaurantapi.entity.Restaurant;
import com.restaurantapi.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Restaurant addRestaurant(@Valid @RequestBody RestaurantDTO dto) {

        Restaurant restaurant = new Restaurant();

        restaurant.setName(dto.getName());
        restaurant.setLocation(dto.getLocation());
        restaurant.setRating(dto.getRating());

        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping
    public Page<Restaurant> getAllRestaurants(Pageable pageable) {
        return restaurantService.getRestaurants(pageable);
    }
    
   
}