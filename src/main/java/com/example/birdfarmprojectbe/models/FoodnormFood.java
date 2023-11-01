package com.example.birdfarmprojectbe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "foodnorm_food")
public class FoodnormFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "foodTypeID", nullable = false)
    private FoodType foodTypeID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "foodNormID", nullable = false)
    private FoodNorm foodNormID;

    @NotNull
    @Nationalized
    @Column(name = "quantity",nullable = false)
    private Integer quantity;

}
