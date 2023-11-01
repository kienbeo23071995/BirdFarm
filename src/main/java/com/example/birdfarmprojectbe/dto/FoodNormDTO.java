package com.example.birdfarmprojectbe.dto;

import com.example.birdfarmprojectbe.models.BirdType;

import java.time.LocalTime;
import java.util.List;

public class FoodNormDTO {
    private Integer id;
    private BirdType birdType;

    private Integer duration;

    private Integer numberOfFeeding;

    private LocalTime startTime;

    private String note;

    private Integer water;

    private List<FoodNormMedicineDTO> foodNormMedicineDTOS;

    private List<FoodNormFoodDTO> foodNormFoodDTOS;

    public FoodNormDTO() {
    }

    public FoodNormDTO(Integer id, BirdType birdType, Integer duration, Integer numberOfFeeding, LocalTime startTime, String note, List<FoodNormMedicineDTO> foodNormMedicineDTOS, List<FoodNormFoodDTO> foodNormFoodDTOS) {
        this.id = id;
        this.birdType = birdType;
        this.duration = duration;
        this.numberOfFeeding = numberOfFeeding;
        this.startTime = startTime;
        this.note = note;
        this.foodNormMedicineDTOS = foodNormMedicineDTOS;
        this.foodNormFoodDTOS = foodNormFoodDTOS;
    }

    public FoodNormDTO(Integer id, BirdType birdType, Integer duration, Integer numberOfFeeding, LocalTime startTime, String note, Integer water, List<FoodNormMedicineDTO> foodNormMedicineDTOS, List<FoodNormFoodDTO> foodNormFoodDTOS) {
        this.id = id;
        this.birdType = birdType;
        this.duration = duration;
        this.numberOfFeeding = numberOfFeeding;
        this.startTime = startTime;
        this.note = note;
        this.water = water;
        this.foodNormMedicineDTOS = foodNormMedicineDTOS;
        this.foodNormFoodDTOS = foodNormFoodDTOS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BirdType getBirdType() {
        return birdType;
    }

    public void setBirdType(BirdType birdType) {
        this.birdType = birdType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getNumberOfFeeding() {
        return numberOfFeeding;
    }

    public void setNumberOfFeeding(Integer numberOfFeeding) {
        this.numberOfFeeding = numberOfFeeding;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public List<FoodNormMedicineDTO> getFoodNormMedicineDTOS() {
        return foodNormMedicineDTOS;
    }

    public void setFoodNormMedicineDTOS(List<FoodNormMedicineDTO> foodNormMedicineDTOS) {
        this.foodNormMedicineDTOS = foodNormMedicineDTOS;
    }

    public List<FoodNormFoodDTO> getFoodNormFoodDTOS() {
        return foodNormFoodDTOS;
    }

    public void setFoodNormFoodDTOS(List<FoodNormFoodDTO> foodNormFoodDTOS) {
        this.foodNormFoodDTOS = foodNormFoodDTOS;
    }
}
