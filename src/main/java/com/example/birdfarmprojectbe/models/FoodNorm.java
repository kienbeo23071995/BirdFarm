package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class FoodNorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "birdTypeID", nullable = false)
    private BirdType birdType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "foodTypeID", nullable = false)
    private FoodType foodType;

    @NotNull
    @Column(name = "quantityFood", nullable = false)
    private Integer quantityFood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicineID")
    private Medicine medicine;

    @Null
    @Column(name = "quantityMedicine")
    private Integer quantityMedicine;

    @NotNull
    @Column(name = "numberOfFeeding", nullable = false)
    private Integer numberOfFeeding;

    @NotNull
    @Column(name = "startTime",nullable = false)
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime startTime;

    @NotNull
    @Column(name = "duration",nullable = false)
    private Integer duration;

    @NotNull
    @Column(name = "note")
    private String note;
}
