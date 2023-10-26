package com.example.birdfarmprojectbe.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class BirdCageDTO {

    private String name;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate age;

    private Integer birdTypeID;

    private Integer cageID;

    private Integer statusID;

    private Boolean gender;

    private String attituteds;

    private String qualities;

    private String color;

    private String appearance;

    private Boolean exotic;

    private String exoticrate;

    public BirdCageDTO() {

    }

    public BirdCageDTO(String name, LocalDate age, Integer birdTypeID, Integer cageID, Integer statusID) {
        this.name = name;
        this.age = age;
        this.birdTypeID = birdTypeID;
        this.cageID = cageID;
        this.statusID = statusID;
    }

    public BirdCageDTO(String name, LocalDate age, Integer birdTypeID, Integer cageID, Integer statusID, Boolean gender) {
        this.name = name;
        this.age = age;
        this.birdTypeID = birdTypeID;
        this.cageID = cageID;
        this.statusID = statusID;
        this.gender = gender;
    }

    public BirdCageDTO(String name, LocalDate age, Integer birdTypeID, Integer cageID, Integer statusID, Boolean gender, String attituteds, String qualities, String color, String appearance, Boolean exotic, String exoticrate) {
        this.name = name;
        this.age = age;
        this.birdTypeID = birdTypeID;
        this.cageID = cageID;
        this.statusID = statusID;
        this.gender = gender;
        this.attituteds = attituteds;
        this.qualities = qualities;
        this.color = color;
        this.appearance = appearance;
        this.exotic = exotic;
        this.exoticrate = exoticrate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public Integer getBirdTypeID() {
        return birdTypeID;
    }

    public void setBirdTypeID(Integer birdTypeID) {
        this.birdTypeID = birdTypeID;
    }

    public Integer getCageID() {
        return cageID;
    }

    public void setCageID(Integer cageID) {
        this.cageID = cageID;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAttituteds() {
        return attituteds;
    }

    public void setAttituteds(String attituteds) {
        this.attituteds = attituteds;
    }

    public String getQualities() {
        return qualities;
    }

    public void setQualities(String qualities) {
        this.qualities = qualities;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public Boolean getExotic() {
        return exotic;
    }

    public void setExotic(Boolean exotic) {
        this.exotic = exotic;
    }

    public String getExoticrate() {
        return exoticrate;
    }

    public void setExoticrate(String exoticrate) {
        this.exoticrate = exoticrate;
    }
}
