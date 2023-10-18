package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.BirdCage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BirdCageRepository extends JpaRepository<BirdCage, Integer> {
    @Query(value = "Select Cage.[max] - Cage.quantity as num from Cage where id = ?1",nativeQuery = true)
    Integer getNumOfRemainsCage(Integer cageID);
}
