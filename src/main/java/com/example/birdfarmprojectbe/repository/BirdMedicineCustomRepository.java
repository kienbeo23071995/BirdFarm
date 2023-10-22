package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.dto.MedicineCustomDTO;
import com.example.birdfarmprojectbe.dto.MedicineDTO;
import com.example.birdfarmprojectbe.models.BirdMedicine;

import java.util.List;

public interface BirdMedicineCustomRepository {
    void insertBulk(List<MedicineCustomDTO> birdMedicines);
}
