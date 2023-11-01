package com.example.birdfarmprojectbe.dto;

import com.example.birdfarmprojectbe.models.FoodType;

public class FoodNormFoodDTO {
    private FoodType foodType;
    private Integer quantity;

    public FoodNormFoodDTO() {
    }

    public FoodNormFoodDTO(FoodType foodType, Integer quantity) {
        this.foodType = foodType;
        this.quantity = quantity;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
