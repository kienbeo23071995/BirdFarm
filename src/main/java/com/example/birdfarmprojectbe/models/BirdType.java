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
@Table(name = "bird_type")
public class BirdType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specieid")
    private Species specieid;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "birdTypeid")
    @JsonIgnore
    private Set<Bird> birds = new LinkedHashSet<>();

    @OneToMany(mappedBy = "birdTypeid")
    @JsonIgnore
    private Set<Cage> cages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "birdTypeid")
    @JsonIgnore
    private Set<FoodNorm> foodNorms = new LinkedHashSet<>();

}
