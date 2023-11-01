package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.BirdStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BirdStatusRepository extends JpaRepository<BirdStatus, Integer> {
    @Query(value = "Select BirdStatus from BirdStatus where birdid.id = :birdID and statusid.id = :statusID and endDate = null ")
    public BirdStatus getCurrentBirdStatusByBirdIDAndStatusID(int birdID,int statusID);
}
