package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.models.Bird;
import com.example.birdfarmprojectbe.models.BirdCage;
import com.example.birdfarmprojectbe.repository.BirdCageRepository;
import com.example.birdfarmprojectbe.repository.BirdRepository;
import com.example.birdfarmprojectbe.repository.CageRepository;
import com.example.birdfarmprojectbe.service.FileUpload;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/bird")
@AllArgsConstructor
public class BirdAPI {
    private final BirdRepository birdRepository;

    private final FileUpload fileUpload;

    private final String ENTITY_NAME = "BirdAPI";

    private final BirdCageRepository birdCageRepository;
    private final CageRepository cageRepository;

    @GetMapping("/")
    public ResponseEntity<List<Bird>> getAll(){
        return ResponseEntity.ok(birdRepository.findAll());
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Bird> save(@RequestPart("bird") String birdJson, @RequestParam("file") MultipartFile file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Bird bird = objectMapper.readValue(birdJson,Bird.class);
            bird.setImage(fileUpload.uploadFile(file));
            return ResponseEntity.ok(birdRepository.save(bird));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bird> update(@PathVariable final Integer id,@RequestBody Bird bird)
            throws URISyntaxException {
        if (!Objects.equals(id, bird.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!birdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Bird result = birdRepository.save(bird);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        birdRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping("/addBirdToCage")
    public ResponseEntity<Bird> addBirdToCage(@RequestParam("birdID") Integer birdID,@RequestParam("cageID") Integer cageID) {
        Integer num = birdCageRepository.getNumOfRemainsCage(cageID);
        if(num == 0){
            throw new BadRequestAlertException("Cage is full now!",ENTITY_NAME,"cagefull");
        }
        BirdCage birdCage = new BirdCage();
        birdCage.setBirdID(birdRepository.findById(birdID).get());
        birdCage.setCageID(cageRepository.findById(cageID).get());
        birdCage.setStartDate(Instant.now());
        birdCageRepository.save(birdCage);
        return ResponseEntity
                .ok()
                .body(birdRepository.findById(birdID).get());
    }
}
