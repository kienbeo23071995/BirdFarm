package com.example.birdfarmprojectbe.service;

import com.example.birdfarmprojectbe.models.FoodNorm;

import java.util.List;

public interface FoodNormService {
    public List<FoodNorm> get(Integer birdTypeID);
}
