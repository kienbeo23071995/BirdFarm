package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.Status;
import com.example.birdfarmprojectbe.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/status")
@AllArgsConstructor
public class StatusAPI {
    private final StatusRepository statusRepository;

    private final String ENTITY_NAME = "StatusAPI";

    @GetMapping("/")
    public ResponseEntity<List<Status>> getAll(){
        return ResponseEntity.ok(statusRepository.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Status> save(@RequestBody Status status) {
        statusRepository.save(status);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Status> update(@PathVariable final Integer id, @RequestBody Status status)
            throws URISyntaxException {
        if (!Objects.equals(id, status.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!statusRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Status result = statusRepository.save(status);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PutMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id)
    {
        statusRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
