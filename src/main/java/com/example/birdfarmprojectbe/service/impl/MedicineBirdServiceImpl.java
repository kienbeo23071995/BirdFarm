package com.example.birdfarmprojectbe.service.impl;

import com.example.birdfarmprojectbe.dto.MedicineCustomDTO;
import com.example.birdfarmprojectbe.dto.MedicineDTO;
import com.example.birdfarmprojectbe.repository.BirdMedicineRepository;
import com.example.birdfarmprojectbe.service.MedicineBirdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class MedicineBirdServiceImpl implements MedicineBirdService {
    private final BirdMedicineRepository birdMedicineRepository;
    @Override
    public void insertBulk(List<MedicineCustomDTO> medicineDTOList) {
        birdMedicineRepository.insertBulk(medicineDTOList);
    }
}
