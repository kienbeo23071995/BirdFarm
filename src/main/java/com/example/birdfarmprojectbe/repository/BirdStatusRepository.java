package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.BirdStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BirdStatusRepository extends JpaRepository<BirdStatus, Integer> {
    @Query(value = "Select * from bird_status where birdid = ?1 and statusid = ?2 and end_date is null",nativeQuery = true)
    BirdStatus getCurrentBirdStatusByBirdIDAndStatusID(Integer birdID,Integer statusID);
}
