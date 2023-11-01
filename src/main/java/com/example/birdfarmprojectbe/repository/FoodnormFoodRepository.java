package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.FoodnormFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodnormFoodRepository extends JpaRepository<FoodnormFood, Integer> {
    @Query(value = "delete from foodnorm_food where foodNormID = ?1",nativeQuery = true)
    void deleteByFoodNormID(Integer id);
}
