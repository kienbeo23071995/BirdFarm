package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.dto.MedicineCustomDTO;
import com.example.birdfarmprojectbe.models.BirdMedicine;
import com.example.birdfarmprojectbe.models.TaskBird;
import com.example.birdfarmprojectbe.repository.BirdMedicineRepository;
import com.example.birdfarmprojectbe.repository.BirdRepository;
import com.example.birdfarmprojectbe.service.MedicineBirdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/scheduleMedicine")
@AllArgsConstructor
public class ScheduleMedicine {
    private final String ENTITY_NAME = "ScheduleMedicineAPI";

    private final BirdMedicineRepository birdMedicineRepository;

    private final BirdRepository birdRepository;

    private final MedicineBirdService medicineBirdService;

    @GetMapping("/getall")
    public ResponseEntity<List<BirdMedicine>> getAll(){
        return ResponseEntity.ok(birdMedicineRepository.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<BirdMedicine>> save(@RequestBody List<MedicineCustomDTO> medicineDTOList) throws ParseException {
        medicineBirdService.insertBulk(medicineDTOList);
        return ResponseEntity.ok(birdMedicineRepository.findAll());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<BirdMedicine> update(@PathVariable final Integer id, @RequestBody BirdMedicine birdMedicine) throws ParseException
    {
        if (!Objects.equals(id, birdMedicine.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!birdMedicineRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        BirdMedicine result = birdMedicineRepository.save(birdMedicine);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PutMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id)
    {
        birdMedicineRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
