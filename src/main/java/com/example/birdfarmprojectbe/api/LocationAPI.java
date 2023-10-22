package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.Cage;
import com.example.birdfarmprojectbe.models.Location;
import com.example.birdfarmprojectbe.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/location")
@AllArgsConstructor
public class LocationAPI {
    private final LocationRepository locationRepository;

    private final String ENTITY_NAME = "CageAPI";

    @GetMapping("/")
    public ResponseEntity<List<Location>> getAll(){
        return ResponseEntity.ok(locationRepository.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Location> save(@RequestBody Location location) {
        locationRepository.save(location);
        return ResponseEntity.ok(location);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Location> update(@PathVariable final Integer id,@RequestBody Location location)
            throws URISyntaxException {
        if (!Objects.equals(id, location.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!locationRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Location result = locationRepository.save(location);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PutMapping(value = "/deleteTaskBird/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id)
    {
        locationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
