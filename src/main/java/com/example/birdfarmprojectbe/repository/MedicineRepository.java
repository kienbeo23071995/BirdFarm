package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
}
