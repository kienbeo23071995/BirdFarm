package com.example.birdfarmprojectbe.dto;

import java.time.LocalDateTime;

public class MedicineCustomDTO {
    private Integer birdID;
    private Integer medicineID;
    private LocalDateTime date;
    private Integer quantity;

    public MedicineCustomDTO() {
    }

    public MedicineCustomDTO(Integer birdID, Integer medicineID, LocalDateTime date, Integer quantity) {
        this.birdID = birdID;
        this.medicineID = medicineID;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
