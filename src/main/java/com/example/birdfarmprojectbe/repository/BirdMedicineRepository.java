package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.BirdMedicine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BirdMedicineRepository extends JpaRepository<BirdMedicine, Integer>,BirdMedicineCustomRepository {
}
