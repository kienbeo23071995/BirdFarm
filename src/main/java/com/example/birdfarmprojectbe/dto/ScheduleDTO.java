package com.example.birdfarmprojectbe.dto;

import java.util.List;

public class ScheduleDTO {
    private String startDate;

    private String endDate;

    private Integer staffID;

    private String note;

    private Integer status;

    private List<FoodNormFoodDTO> foodList;

    private List<FoodNormMedicineDTO> medicineList;

    public ScheduleDTO() {
    }

    public ScheduleDTO(String startDate, String endDate, Integer staffID, String note, Integer status, List<FoodNormFoodDTO> foodList, List<FoodNormMedicineDTO> medicineList) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.staffID = staffID;
        this.note = note;
        this.status = status;
        this.foodList = foodList;
        this.medicineList = medicineList;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<FoodNormFoodDTO> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FoodNormFoodDTO> foodList) {
        this.foodList = foodList;
    }

    public List<FoodNormMedicineDTO> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<FoodNormMedicineDTO> medicineList) {
        this.medicineList = medicineList;
    }


}
