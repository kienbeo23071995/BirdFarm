package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTypeRepository extends JpaRepository<FoodType, Integer> {
}
