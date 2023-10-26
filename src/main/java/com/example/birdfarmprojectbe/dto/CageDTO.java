package com.example.birdfarmprojectbe.dto;

import com.example.birdfarmprojectbe.models.Location;

public class CageDTO {
    private String type;

    private Integer max;

    private Integer quantity;

    private Integer locationID;

    public CageDTO() {
    }

    public CageDTO(String type, Integer max, Integer quantity, Integer locationID) {
        this.type = type;
        this.max = max;
        this.quantity = quantity;
        this.locationID = locationID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }
}
