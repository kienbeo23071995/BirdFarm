package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "foodnorm_medicine")
public class FoodnormMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medicineID", nullable = false)
    private Medicine medicineID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "foodNormID", nullable = false)
    @JsonIgnore
    private FoodNorm foodNormID;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
