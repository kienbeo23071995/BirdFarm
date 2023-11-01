package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.FoodnormMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodnormMedicineRepository extends JpaRepository<FoodnormMedicine, Integer> {
    @Query(value = "delete from foodnorm_medicine where foodNormID = ?1",nativeQuery = true)
    void deleteByFoodNormID(Integer id);
}
