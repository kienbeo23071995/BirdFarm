package com.example.birdfarmprojectbe.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medicineID")
    private Medicine medicine;

    @NotNull
    @Column(name = "quantityMedicine")
    private Integer quantityMedicine;

    @NotNull
    @Column(name = "numberOfFeeding", nullable = false)
    private Integer numberOfFeeding;

    @NotNull
    @Column(name = "startTime",nullable = false)
    private LocalTime startTime;

    @NotNull
    @Column(name = "duration",nullable = false)
    private Integer duration;

    @NotNull
    @Column(name = "note")
    private String note;
}
