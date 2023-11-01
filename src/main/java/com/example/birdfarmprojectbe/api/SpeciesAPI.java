package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.Species;
import com.example.birdfarmprojectbe.repository.SpeciesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/species")
@AllArgsConstructor
public class SpeciesAPI {
    private final SpeciesRepository speciesRepository;

    private final String ENTITY_NAME = "SpeciesAPI";

    @GetMapping("/")
    public ResponseEntity<List<Species>> getAll(){
        return ResponseEntity.ok(speciesRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Species> create(@RequestBody Species species){
        return ResponseEntity.ok(speciesRepository.save(species));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Species> update(@PathVariable final Integer id,@RequestBody Species species)
            throws URISyntaxException {
        if (!Objects.equals(id, species.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!speciesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Species result = speciesRepository.save(species);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        speciesRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
