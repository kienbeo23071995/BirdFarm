package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.dto.FoodNormDTO;
import com.example.birdfarmprojectbe.dto.FoodNormFoodDTO;
import com.example.birdfarmprojectbe.dto.FoodNormMedicineDTO;
import com.example.birdfarmprojectbe.models.FoodNorm;
import com.example.birdfarmprojectbe.models.FoodnormFood;
import com.example.birdfarmprojectbe.models.FoodnormMedicine;
import com.example.birdfarmprojectbe.repository.FoodNormRepository;
import com.example.birdfarmprojectbe.repository.FoodTypeRepository;
import com.example.birdfarmprojectbe.repository.FoodnormFoodRepository;
import com.example.birdfarmprojectbe.repository.FoodnormMedicineRepository;
import com.example.birdfarmprojectbe.service.FoodNormService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/foodnorm")
@AllArgsConstructor
public class FoodNormAPI {
    private final FoodNormRepository foodNormRepository;

    private final FoodnormMedicineRepository foodnormMedicineRepository;

    private final FoodnormFoodRepository foodnormFoodRepository;

    private final FoodNormService foodNormService;

    private final String ENTITY_NAME = "FoodNormAPI";

    @PostMapping("/create")
    public ResponseEntity<FoodNorm> create(@RequestBody FoodNormDTO foodNormDTO){
        FoodNorm foodNorm = new FoodNorm();
        foodNorm.setNote(foodNormDTO.getNote());
        foodNorm.setDuration(foodNormDTO.getDuration());
        foodNorm.setBirdTypeid(foodNormDTO.getBirdType());
        foodNorm.setWater(foodNormDTO.getWater());
        foodNorm.setStartTime(foodNormDTO.getStartTime());
        foodNorm.setNumberOfFeeding(foodNormDTO.getNumberOfFeeding());
        foodNormRepository.save(foodNorm);
        if(foodNormDTO.getFoodNormFoodDTOS() != null){
            foodnormFoodRepository.deleteByFoodNormID(foodNorm.getId());
            for(FoodNormFoodDTO item : foodNormDTO.getFoodNormFoodDTOS()){
                FoodnormFood f = new FoodnormFood();
                f.setQuantity(item.getQuantity());
                f.setFoodNormID(foodNorm);
                f.setFoodTypeID(f.getFoodTypeID());
                foodnormFoodRepository.save(f);
            }
        }
        if(foodNormDTO.getFoodNormMedicineDTOS() != null){
            foodnormMedicineRepository.deleteByFoodNormID(foodNorm.getId());
            for(FoodNormMedicineDTO item : foodNormDTO.getFoodNormMedicineDTOS()){
                FoodnormMedicine i = new FoodnormMedicine();
                i.setQuantity(item.getQuantity());
                i.setFoodNormID(foodNorm);
                i.setMedicineID(item.getMedicine());
                foodnormMedicineRepository.save(i);
            }
        }
        return ResponseEntity.ok(foodNorm);
    }

    @GetMapping("/get")
    public ResponseEntity<List<FoodNorm>> get(@RequestParam(value = "birdTypeID",required = false) Integer birdTypeID){
        return ResponseEntity.ok(foodNormService.get(birdTypeID));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<FoodNorm> update(@PathVariable final Integer id,@RequestBody FoodNormDTO foodNormDTO){
        if (!Objects.equals(id, foodNormDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!foodNormRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        FoodNorm foodNorm = foodNormRepository.findById(id).get();
        foodNorm.setNote(foodNormDTO.getNote());
        foodNorm.setDuration(foodNormDTO.getDuration());
        foodNorm.setBirdTypeid(foodNormDTO.getBirdType());
        foodNorm.setWater(foodNormDTO.getWater());
        foodNorm.setStartTime(foodNormDTO.getStartTime());
        foodNorm.setNumberOfFeeding(foodNormDTO.getNumberOfFeeding());
        foodNormRepository.save(foodNorm);
        if(foodNormDTO.getFoodNormFoodDTOS() != null){
            foodnormFoodRepository.deleteByFoodNormID(foodNorm.getId());
            for(FoodNormFoodDTO item : foodNormDTO.getFoodNormFoodDTOS()){
                FoodnormFood f = new FoodnormFood();
                f.setQuantity(item.getQuantity());
                f.setFoodNormID(foodNorm);
                f.setFoodTypeID(f.getFoodTypeID());
                foodnormFoodRepository.save(f);
            }
        }
        if(foodNormDTO.getFoodNormMedicineDTOS() != null){
            foodnormMedicineRepository.deleteByFoodNormID(foodNorm.getId());
            for(FoodNormMedicineDTO item : foodNormDTO.getFoodNormMedicineDTOS()){
                FoodnormMedicine i = new FoodnormMedicine();
                i.setQuantity(item.getQuantity());
                i.setFoodNormID(foodNorm);
                i.setMedicineID(item.getMedicine());
                foodnormMedicineRepository.save(i);
            }
        }
        return ResponseEntity.ok(foodNorm);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<FoodNorm> delete(@PathVariable final Integer id){
        foodnormFoodRepository.deleteByFoodNormID(id);
        foodnormMedicineRepository.deleteByFoodNormID(id);
        foodNormRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
