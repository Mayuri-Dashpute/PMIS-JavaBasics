package com.foodorder.service;

import com.foodorder.dto.FoodRequest;
import com.foodorder.entity.Food;
import com.foodorder.exception.ResourceNotFoundException;
import com.foodorder.repository.FoodRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Food not found with id: " + id));
    }

    public Food addFood(FoodRequest request) {

        Food food = new Food(
                request.getName(),
                request.getCategory(),
                request.getPrice(),
                request.isAvailable()
        );

        return foodRepository.save(food);
    }

    public Food updateFood(Long id, FoodRequest request) {

        Food food = getFoodById(id);

        food.setName(request.getName());
        food.setCategory(request.getCategory());
        food.setPrice(request.getPrice());
        food.setAvailable(request.isAvailable());

        return foodRepository.save(food);
    }

    public void deleteFood(Long id) {

        Food food = getFoodById(id);

        foodRepository.delete(food);
    }
}