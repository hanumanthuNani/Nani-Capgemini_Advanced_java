package com.restaurantapi.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.restaurantapi.dto.FoodItemDTO;
import com.restaurantapi.entity.FoodItem;
import com.restaurantapi.entity.Restaurant;
import com.restaurantapi.exception.ResourceNotFoundException;
import com.restaurantapi.repository.FoodItemRepository;
import com.restaurantapi.repository.RestaurantRepository;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final RestaurantRepository restaurantRepository;

    public FoodItemService(FoodItemRepository foodItemRepository,
                           RestaurantRepository restaurantRepository) {
        this.foodItemRepository = foodItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public FoodItemDTO addFoodItem(Long restaurantId, FoodItemDTO dto) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        FoodItem food = new FoodItem();
        food.setName(dto.getName());
        food.setPrice(dto.getPrice());
        food.setCategory(dto.getCategory());
        food.setRestaurant(restaurant);

        FoodItem saved = foodItemRepository.save(food);

        return new FoodItemDTO(
                saved.getId(),
                saved.getName(),
                saved.getPrice(),
                saved.getCategory()
        );
    }

    public List<FoodItemDTO> getFoodItemsByRestaurant(Long restaurantId) {

        return foodItemRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(food -> new FoodItemDTO(
                        food.getId(),
                        food.getName(),
                        food.getPrice(),
                        food.getCategory()
                ))
                .collect(Collectors.toList());
    }
}