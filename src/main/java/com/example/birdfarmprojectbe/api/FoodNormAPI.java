package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.models.Bird;
import com.example.birdfarmprojectbe.models.FoodNorm;
import com.example.birdfarmprojectbe.repository.FoodNormRepository;
import com.example.birdfarmprojectbe.service.FoodNormService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/foodnorm")
@AllArgsConstructor
public class FoodNormAPI {
    private final FoodNormRepository foodNormRepository;

    private final FoodNormService foodNormService;

    @PostMapping("/create")
    public ResponseEntity<FoodNorm> create(@RequestBody FoodNorm foodNorm){
        return ResponseEntity.ok(foodNormRepository.save(foodNorm));
    }

    @GetMapping("/get")
    public ResponseEntity<List<FoodNorm>> get(@RequestParam(value = "birdTypeID",required = false) Integer birdTypeID){
        return ResponseEntity.ok(foodNormService.get(birdTypeID));
    }
}
