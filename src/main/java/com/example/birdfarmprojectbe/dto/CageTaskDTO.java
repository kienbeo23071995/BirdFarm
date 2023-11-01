package com.example.birdfarmprojectbe.dto;

import com.example.birdfarmprojectbe.models.FoodNorm;

import java.util.List;

public class CageTaskDTO {
    private Integer cageID;
    private List<ScheduleDTO> schedules;
    private Integer foodNormID;

    public CageTaskDTO() {
    }

    public CageTaskDTO(Integer cageID, List<ScheduleDTO> schedules, Integer foodNormID) {
        this.cageID = cageID;
        this.schedules = schedules;
        this.foodNormID = foodNormID;
    }

    public Integer getCageID() {
        return cageID;
    }

    public void setCageID(Integer cageID) {
        this.cageID = cageID;
    }

    public List<ScheduleDTO> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDTO> schedules) {
        this.schedules = schedules;
    }

    public Integer getFoodNormID() {
        return foodNormID;
    }

    public void setFoodNormID(Integer foodNormID) {
        this.foodNormID = foodNormID;
    }
}
