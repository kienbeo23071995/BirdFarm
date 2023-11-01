package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "food_norm")
public class FoodNorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bird_typeid", nullable = false)
    private BirdType birdTypeid;

    @NotNull
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @NotNull
    @Column(name = "number_of_feeding", nullable = false)
    private Integer numberOfFeeding;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Size(max = 255)
    @Column(name = "note")
    private String note;

    @Column(name = "water")
    private Integer water;

    @OneToMany(mappedBy = "foodNormID")
    private Set<FoodnormFood> foodnormFoods = new LinkedHashSet<>();

    @OneToMany(mappedBy = "foodNormID")

    private Set<FoodnormMedicine> foodnormMedicines = new LinkedHashSet<>();

    @OneToMany(mappedBy = "foodNormID")
    private Set<TaskBird> taskBirds = new LinkedHashSet<>();
}
