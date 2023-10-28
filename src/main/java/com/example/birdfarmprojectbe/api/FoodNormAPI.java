package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.Bird;
import com.example.birdfarmprojectbe.models.BirdType;
import com.example.birdfarmprojectbe.models.FoodNorm;
import com.example.birdfarmprojectbe.repository.FoodNormRepository;
import com.example.birdfarmprojectbe.service.FoodNormService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/foodnorm")
@AllArgsConstructor
public class FoodNormAPI {
    private final FoodNormRepository foodNormRepository;

    private final FoodNormService foodNormService;

    private final String ENTITY_NAME = "FoodNormAPI";

    @PostMapping("/create")
    public ResponseEntity<FoodNorm> create(@RequestBody FoodNorm foodNorm){
        return ResponseEntity.ok(foodNormRepository.save(foodNorm));
    }

    @GetMapping("/get")
    public ResponseEntity<List<FoodNorm>> get(@RequestParam(value = "birdTypeID",required = false) Integer birdTypeID){
        return ResponseEntity.ok(foodNormService.get(birdTypeID));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<FoodNorm> update(@PathVariable final Integer id,@RequestBody FoodNorm foodNorm){
        if (!Objects.equals(id, foodNorm.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!foodNormRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        FoodNorm result = foodNormRepository.save(foodNorm);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<FoodNorm> delete(@PathVariable final Integer id){
        foodNormRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
