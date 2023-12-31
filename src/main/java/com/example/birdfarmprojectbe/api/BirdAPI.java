package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.dto.BirdCageDTO;
import com.example.birdfarmprojectbe.models.*;
import com.example.birdfarmprojectbe.repository.*;
import com.example.birdfarmprojectbe.service.FileUpload;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;


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
    private final BirdTypeRepository birdTypeRepository;
    private final BirdStatusRepository birdStatusRepository;
    private final StatusRepository statusRepository;

    @GetMapping("/")
    public ResponseEntity<List<Bird>> getAll(){
        return ResponseEntity.ok(birdRepository.findAll());
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Bird> save(@RequestPart("bird") String birdJson, @RequestParam("file") MultipartFile file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BirdCageDTO birdCageDTO = objectMapper.readValue(birdJson,BirdCageDTO.class);
            Bird bird = new Bird();
            bird.setName(birdCageDTO.getName());
            bird.setAge(birdCageDTO.getAge());
            bird.setBirdTypeid(birdTypeRepository.findById(birdCageDTO.getBirdTypeID()).get());
            bird.setImage(fileUpload.uploadFile(file));
            bird.setGender(birdCageDTO.getGender());
            bird.setAttituteds(birdCageDTO.getAttituteds());
            bird.setAppearance(birdCageDTO.getAppearance());
            bird.setColor(birdCageDTO.getColor());
            bird.setExotic(birdCageDTO.getExotic());
            bird.setExoticrate(birdCageDTO.getExoticrate());
            bird.setQualities(birdCageDTO.getQualities());
            birdRepository.save(bird);
            Status status = statusRepository.findById(birdCageDTO.getStatusID()).get();
            BirdStatus birdStatus = new BirdStatus();
            birdStatus.setBirdid(bird);
            birdStatus.setStatusid(status);
            birdStatus.setStartDate(LocalDate.now());
            birdStatusRepository.save(birdStatus);
            BirdCage birdCage = new BirdCage();
            Cage cage = cageRepository.findById(birdCageDTO.getCageID()).get();
            cage.setQuantity(cage.getQuantity() + 1);
            cageRepository.save(cage);
            birdCage.setCageid(cage);
            birdCage.setBirdid(bird);
            birdCage.setStartDate(LocalDate.now());
            birdCageRepository.save(birdCage);
            return ResponseEntity.ok(bird);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(value ="/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Bird> update(@PathVariable final Integer id,@RequestPart("bird") String birdJson, @RequestParam("file") MultipartFile file)
            throws URISyntaxException {
        if (!birdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            BirdCageDTO birdCageDTO = objectMapper.readValue(birdJson,BirdCageDTO.class);
            Bird bird = birdRepository.findById(id).get();
            bird.setName(birdCageDTO.getName());
            bird.setAge(birdCageDTO.getAge());
            bird.setBirdTypeid(birdTypeRepository.findById(birdCageDTO.getBirdTypeID()).get());
            bird.setImage(fileUpload.uploadFile(file));
            bird.setGender(birdCageDTO.getGender());
            bird.setAttituteds(birdCageDTO.getAttituteds());
            bird.setAppearance(birdCageDTO.getAppearance());
            bird.setColor(birdCageDTO.getColor());
            bird.setExotic(birdCageDTO.getExotic());
            bird.setExoticrate(birdCageDTO.getExoticrate());
            bird.setQualities(birdCageDTO.getQualities());
            birdRepository.save(bird);
            if(birdCageDTO.getStatusID() != null){
                Status status = statusRepository.findById(birdCageDTO.getStatusID()).get();
                BirdStatus birdStatus = new BirdStatus();
                birdStatus.setBirdid(bird);
                birdStatus.setStatusid(status);
                birdStatus.setStartDate(LocalDate.now());
                BirdStatus oldBirdStatus = birdStatusRepository.getCurrentBirdStatusByBirdIDAndStatusID(bird.getId(), birdCageDTO.getStatusID());
                oldBirdStatus.setEndDate(LocalDate.now());
                birdStatusRepository.save(oldBirdStatus);
                birdStatusRepository.save(birdStatus);
            }
            if(birdCageDTO.getCageID() != null){
                BirdCage birdCage = new BirdCage();
                Cage cage = cageRepository.findById(birdCageDTO.getCageID()).get();
                Cage currentCage = cageRepository.getCurrentCageByBirdID(id);
                currentCage.setQuantity(currentCage.getQuantity() - 1);
                cageRepository.save(currentCage);
                cage.setQuantity(cage.getQuantity() + 1);
                cageRepository.save(cage);
                birdCage.setCageid(cage);
                birdCage.setBirdid(bird);
                birdCage.setStartDate(LocalDate.now());
                birdCageRepository.save(birdCage);
                BirdCage oldBirdCage = birdCageRepository.getBirdCageByBirdIDAndCageID(cage.getId(), bird.getId());
                oldBirdCage.setEndDate(LocalDate.now());
                birdCageRepository.save(oldBirdCage);
            }
            return ResponseEntity
                    .ok()
                    .body(bird);
        } catch (Exception e) {
            throw new BadRequestAlertException("Exception", ENTITY_NAME, "Exception");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Bird bird = birdRepository.findById(id).get();
        birdRepository.deleteById(id);
        Cage cage = cageRepository.getCurrentCageByBirdID(bird.getId());
        cage.setQuantity(cage.getQuantity() - 1);
        cageRepository.save(cage);
        return ResponseEntity
                .noContent()
                .build();
    }

}
