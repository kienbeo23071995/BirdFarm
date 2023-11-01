package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "food_type")
public class FoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "foodTypeID")
    @JsonIgnore
    private Set<FoodnormFood> foodnormFoods = new LinkedHashSet<>();

    @OneToMany(mappedBy = "foodTypeID")
    @JsonIgnore
    private Set<TaskBirdFood> taskBirdFoods = new LinkedHashSet<>();

}
