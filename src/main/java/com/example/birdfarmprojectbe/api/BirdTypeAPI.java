package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.BirdType;
import com.example.birdfarmprojectbe.repository.BirdTypeRepository;
import com.example.birdfarmprojectbe.repository.SpeciesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/birdtype")
@AllArgsConstructor
public class BirdTypeAPI {
    private final BirdTypeRepository birdTypeRepository;

    private final SpeciesRepository speciesRepository;

    private final String ENTITY_NAME = "BirdTypeAPI";

    @GetMapping("/")
    public ResponseEntity<List<BirdType>> getAll(){
        return ResponseEntity.ok(birdTypeRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<BirdType> create(@RequestBody BirdType birdType){
        return ResponseEntity.ok(birdTypeRepository.save(birdType));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BirdType> update(@PathVariable final Integer id,@RequestBody BirdType birdType)
            throws URISyntaxException {
        if (!Objects.equals(id, birdType.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!birdTypeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        BirdType result = birdTypeRepository.save(birdType);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        birdTypeRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
