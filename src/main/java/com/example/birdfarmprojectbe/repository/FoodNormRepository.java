package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.FoodNorm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodNormRepository extends JpaRepository<FoodNorm, Integer> {
    @Query("Select FoodNorm from FoodNorm where birdTypeid.id = :birdTypeID")
    public List<FoodNorm> getFoodNormByBirdTypeID(Integer birdTypeID);
}
