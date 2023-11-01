package com.example.birdfarmprojectbe.dto;

import java.util.List;

public class TaskDTO {
    private Integer accountID;

    private String color;

    private String title;

    private String description;

    private List<CageTaskDTO> cageTaskDTOList;

    public TaskDTO() {
    }

    public TaskDTO(Integer accountID, String color, String title, String description, List<CageTaskDTO> cageTaskDTOList) {
        this.accountID = accountID;
        this.color = color;
        this.title = title;
        this.description = description;
        this.cageTaskDTOList = cageTaskDTOList;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CageTaskDTO> getBirdDTOList() {
        return cageTaskDTOList;
    }

    public void setBirdDTOList(List<CageTaskDTO> birdDTOList) {
        this.cageTaskDTOList = birdDTOList;
    }
}
