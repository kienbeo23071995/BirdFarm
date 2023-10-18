package com.example.birdfarmprojectbe.dto;

import java.util.List;

public class TaskDTO {

    private String color;

    private String title;

    private String description;

    private List<BirdDTO> birdDTOList;

    public TaskDTO() {
    }

    public TaskDTO(String color, String title, String description, List<BirdDTO> birdDTOList) {
        this.color = color;
        this.title = title;
        this.description = description;
        this.birdDTOList = birdDTOList;
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

    public List<BirdDTO> getBirdDTOList() {
        return birdDTOList;
    }

    public void setBirdDTOList(List<BirdDTO> birdDTOList) {
        this.birdDTOList = birdDTOList;
    }
}
