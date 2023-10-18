package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.Bird;
import com.example.birdfarmprojectbe.models.FoodType;
import com.example.birdfarmprojectbe.repository.BirdCageRepository;
import com.example.birdfarmprojectbe.repository.BirdRepository;
import com.example.birdfarmprojectbe.repository.CageRepository;
import com.example.birdfarmprojectbe.repository.FoodTypeRepository;
import com.example.birdfarmprojectbe.service.FileUpload;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/foodtype")
@AllArgsConstructor
public class FoodTypeAPI {
    private final FoodTypeRepository foodTypeRepository;

    private final String ENTITY_NAME = "FoodTypeAPI";

    @GetMapping("/")
    public ResponseEntity<List<FoodType>> getAll(){
        return ResponseEntity.ok(foodTypeRepository.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<FoodType> save(@RequestBody FoodType foodType) {
            return ResponseEntity.ok(foodTypeRepository.save(foodType));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FoodType> update(@PathVariable final Integer id,@RequestBody FoodType foodType)
            throws URISyntaxException {
        if (!Objects.equals(id, foodType.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!foodTypeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        FoodType result = foodTypeRepository.save(foodType);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        foodTypeRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
