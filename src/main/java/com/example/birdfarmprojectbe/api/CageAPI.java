package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.dto.CageDTO;
import com.example.birdfarmprojectbe.models.Cage;
import com.example.birdfarmprojectbe.repository.BirdTypeRepository;
import com.example.birdfarmprojectbe.repository.CageRepository;
import com.example.birdfarmprojectbe.repository.LocationRepository;
import com.example.birdfarmprojectbe.service.FileUpload;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/cage")
@AllArgsConstructor
public class CageAPI {
    private final CageRepository cageRepository;

    private final LocationRepository locationRepository;

    private final BirdTypeRepository birdTypeRepository;

    private final FileUpload fileUpload;

    private final String ENTITY_NAME = "CageAPI";

    @GetMapping("/")
    public ResponseEntity<List<Cage>> getAll(){
        return ResponseEntity.ok(cageRepository.findAll());
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Cage> save(@RequestPart("cage") String cageJson, @RequestParam("file") MultipartFile file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CageDTO cageDTO = objectMapper.readValue(cageJson, CageDTO.class);
            Cage cage = new Cage();
            cage.setMax(cageDTO.getMax());
            cage.setLocationid(locationRepository.findById(cageDTO.getLocationID()).get());
            cage.setType(cageDTO.getType());
            cage.setQuantity(cageDTO.getQuantity());
            cage.setImage(fileUpload.uploadFile(file));
            cage.setBirdTypeid(birdTypeRepository.findById(cageDTO.getBirdTypeID()).get());
            cageRepository.save(cage);
            return ResponseEntity.ok(cage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(value ="/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Cage> update(@PathVariable final Integer id,@RequestPart("cage") String cageJson, @RequestParam("file") MultipartFile file)
            throws URISyntaxException {
        if (!cageRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CageDTO cageDTO = objectMapper.readValue(cageJson, CageDTO.class);
            Cage cage = cageRepository.findById(id).get();
            cage.setMax(cageDTO.getMax());
            cage.setLocationid(locationRepository.findById(cageDTO.getLocationID()).get());
            cage.setType(cageDTO.getType());
            cage.setQuantity(cageDTO.getQuantity());
            cage.setImage(fileUpload.uploadFile(file));
            cage.setBirdTypeid(birdTypeRepository.findById(cageDTO.getBirdTypeID()).get());
            cageRepository.save(cage);
            return ResponseEntity
                    .ok()
                    .body(cage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
