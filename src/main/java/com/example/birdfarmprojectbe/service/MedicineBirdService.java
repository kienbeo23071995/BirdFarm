package com.example.birdfarmprojectbe.service;

import com.example.birdfarmprojectbe.dto.MedicineCustomDTO;
import com.example.birdfarmprojectbe.dto.MedicineDTO;

import java.util.List;

public interface MedicineBirdService {
    public void insertBulk(List<MedicineCustomDTO> medicineDTOList);
}
