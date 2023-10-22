package com.example.birdfarmprojectbe.dto;

import java.util.List;

public class MedicineDTO {
    private Integer birdID;
    private Integer medicineID;
    private List<String> schedules;
    private Integer quantity;

    public MedicineDTO() {
    }

    public MedicineDTO(Integer birdID, Integer medicineID, List<String> schedules, Integer quantity) {
        this.birdID = birdID;
        this.medicineID = medicineID;
        this.schedules = schedules;
        this.quantity = quantity;
    }

    public Integer getBirdID() {
        return birdID;
    }

    public void setBirdID(Integer birdID) {
        this.birdID = birdID;
    }

    public Integer getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(Integer medicineID) {
        this.medicineID = medicineID;
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
