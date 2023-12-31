package com.example.birdfarmprojectbe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "bird_cage")
public class BirdCage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "birdid", nullable = false)
    private Bird birdid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cageid", nullable = false)
    private Cage cageid;

    @Column(name = "end_date")
    private LocalDate endDate;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

}
