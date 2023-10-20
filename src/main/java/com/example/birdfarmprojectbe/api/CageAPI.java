package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.Bird;
import com.example.birdfarmprojectbe.models.Cage;
import com.example.birdfarmprojectbe.repository.BirdRepository;
import com.example.birdfarmprojectbe.repository.CageRepository;
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
@RequestMapping("/api/manager/cage")
@AllArgsConstructor
public class CageAPI {
    private final CageRepository cageRepository;

    private final String ENTITY_NAME = "CageAPI";

    @GetMapping("/")
    public ResponseEntity<List<Cage>> getAll(){
        return ResponseEntity.ok(cageRepository.findAll());
    }

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cage> save(@RequestBody Cage cage) {
        cageRepository.save(cage);
        return ResponseEntity.ok(cage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cage> update(@PathVariable final Integer id,@RequestBody Cage cage)
            throws URISyntaxException {
        if (!Objects.equals(id, cage.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cageRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Cage result = cageRepository.save(cage);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        cageRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/getCageBySpecies/{id}")
    public ResponseEntity<List<Cage>> getCagesBySpecies(@PathVariable final Integer id){
        return ResponseEntity.ok(cageRepository.getCageBySpeciesID(id));
    }

    @GetMapping("/getCageByLocation/{id}")
    public ResponseEntity<List<Cage>> getCagesByLocation(@PathVariable final Integer id){
        return ResponseEntity.ok(cageRepository.getCageByLocationID(id));
    }
}
