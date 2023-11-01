package com.example.birdfarmprojectbe.service.impl;

import com.example.birdfarmprojectbe.models.FoodNorm;
import com.example.birdfarmprojectbe.repository.FoodNormRepository;
import com.example.birdfarmprojectbe.service.FoodNormService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FoodNormServiceImpl implements FoodNormService {
    private final FoodNormRepository foodNormRepository;
    @Override
    public List<FoodNorm> get(Integer birdTypeID) {
        if(birdTypeID != null && birdTypeID.intValue() > 0){
            return foodNormRepository.getFoodNormByBirdTypeID(birdTypeID);
        }
        return foodNormRepository.findAll();
    }
}
