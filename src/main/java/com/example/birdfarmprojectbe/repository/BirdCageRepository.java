package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.BirdCage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface BirdCageRepository extends JpaRepository<BirdCage, Integer> {
    @Query(value = "Select Cage.[max] - Cage.quantity as num from Cage where id = ?1",nativeQuery = true)
    Integer getNumOfRemainsCage(Integer cageID);

    @Query(value = "Select bc from BirdCage bc where bc.cageID.id = :cageID")
    Set<BirdCage> getBirdCageByCageID(Integer cageID);

    @Query(value = "Select * from bird_cage where birdid = ?1 and end_date is null",nativeQuery = true)
    BirdCage getBirdCageByBirdIDAndCageID(Integer birdID);
}
