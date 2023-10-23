package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.models.Bird;
import com.example.birdfarmprojectbe.models.BirdCage;
import com.example.birdfarmprojectbe.repository.BirdCageRepository;
import com.example.birdfarmprojectbe.repository.BirdRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/birdcage")
@AllArgsConstructor
public class BirdCageAPI {
    private final BirdCageRepository birdCageRepository;

    @GetMapping("/")
    public ResponseEntity<List<BirdCage>> getAll(){
        return ResponseEntity.ok(birdCageRepository.findAll());
    }
}
