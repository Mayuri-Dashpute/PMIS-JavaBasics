package com.foodorder.controller;

import com.foodorder.dto.FoodRequest;
import com.foodorder.entity.Food;
import com.foodorder.service.FoodService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{foodId}")
    public Food getFoodById(@PathVariable Long foodId) {
        return foodService.getFoodById(foodId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Food addFood(@RequestBody FoodRequest request) {
        return foodService.addFood(request);
    }

    @PutMapping("/{foodId}")
    public Food updateFood(
            @PathVariable Long foodId,
            @RequestBody FoodRequest request) {

        return foodService.updateFood(foodId, request);
    }

    @DeleteMapping("/{foodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable Long foodId) {
        foodService.deleteFood(foodId);
    }
}