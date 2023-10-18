package com.example.birdfarmprojectbe.dto;

import java.util.List;

public class BirdDTO {
    private Integer birdID;
    private Integer foodTypeID;
    private List<String> schedules;
    private Integer quantity;

    public BirdDTO() {
    }

    public BirdDTO(Integer birdID, Integer foodTypeID, List<String> schedules, Integer quantity) {
        this.birdID = birdID;
        this.foodTypeID = foodTypeID;
        this.schedules = schedules;
        this.quantity = quantity;
    }

    public Integer getBirdID() {
        return birdID;
    }

    public void setBirdID(Integer birdID) {
        this.birdID = birdID;
    }

    public Integer getFoodTypeID() {
        return foodTypeID;
    }

    public void setFoodTypeID(Integer foodTypeID) {
        this.foodTypeID = foodTypeID;
    }

    public List<String> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<String> schedules) {
        this.schedules = schedules;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
