package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.BirdCage;
import com.example.birdfarmprojectbe.models.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CageRepository extends JpaRepository<Cage, Integer> {
    @Query(value = "Select c.* from Cage c join bird_cage bc on c.id = bc.cageid join bird b on bc.birdid = b.id \n" +
            "join bird_type bt on bt.id = b.bird_typeid where bt.id = ?1 and c.quantity < c.max",nativeQuery = true)
    List<Cage> getCageBySpeciesID(Integer id);

    @Query(value = "Select c.* from cage c join bird_cage bc on c.id = bc.cageid where bc.birdid = ?1 and bc.end_date = null",nativeQuery = true)
    Cage getCurrentCageByBirdID(Integer id);

    @Query(value = "Select * from Cage where locationID = ?1",nativeQuery = true)
    List<Cage> getCageByLocationID(Integer id);
}
