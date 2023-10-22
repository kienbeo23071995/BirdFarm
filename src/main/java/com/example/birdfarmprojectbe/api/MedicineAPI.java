package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.Cage;
import com.example.birdfarmprojectbe.models.Medicine;
import com.example.birdfarmprojectbe.repository.MedicineRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/medicine")
@AllArgsConstructor
public class MedicineAPI {
    private final String ENTITY_NAME = "MedicineAPI";

    private final MedicineRepository medicineRepository;

    @GetMapping("/")
    public ResponseEntity<List<Medicine>> getAll(){
        return ResponseEntity.ok(medicineRepository.findAll());
    }

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicine> save(@RequestBody Medicine medicine) {
        medicineRepository.save(medicine);
        return ResponseEntity.ok(medicine);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medicine> update(@PathVariable final Integer id,@RequestBody Medicine medicine)
            throws URISyntaxException {
        if (!Objects.equals(id, medicine.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!medicineRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Medicine result = medicineRepository.save(medicine);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        medicineRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
