package com.restaurantapi.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.restaurantapi.dto.FoodItemDTO;
import com.restaurantapi.service.FoodItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    // ADMIN adds food to restaurant
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{restaurantId}/fooditems")
    public FoodItemDTO addFoodItem(
            @PathVariable Long restaurantId,
            @Valid @RequestBody FoodItemDTO dto) {

        return foodItemService.addFoodItem(restaurantId, dto);
    }

    // Anyone can see menu
    @GetMapping("/{restaurantId}/fooditems")
    public List<FoodItemDTO> getMenu(@PathVariable Long restaurantId) {

        return foodItemService.getFoodItemsByRestaurant(restaurantId);
    }
}