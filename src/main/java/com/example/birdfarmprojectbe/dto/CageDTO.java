package com.example.birdfarmprojectbe.dto;

public class CageDTO {
    private String type;

    private Integer max;

    private Integer quantity;

    private Integer locationID;

    private Integer birdTypeID;

    public CageDTO() {
    }

    public CageDTO(String type, Integer max, Integer quantity, Integer locationID, Integer birdTypeID) {
        this.type = type;
        this.max = max;
        this.quantity = quantity;
        this.locationID = locationID;
        this.birdTypeID = birdTypeID;
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

    public Integer getBirdTypeID() {
        return birdTypeID;
    }

    public void setBirdTypeID(Integer birdTypeID) {
        this.birdTypeID = birdTypeID;
    }
}
