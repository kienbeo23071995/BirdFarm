package com.example.birdfarmprojectbe.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Bird_Cage")
public class BirdCage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "birdID", nullable = false)
    private Bird birdID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cageID", nullable = false)
    private Cage cageID;

    @NotNull
    @Column(name = "startDate", nullable = false)
    private Instant startDate;

    @Column(name = "endDate")
    private Instant endDate;

}
