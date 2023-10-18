package com.example.birdfarmprojectbe.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class BirdType {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specieID")
    private Species specieID;

    @OneToMany(mappedBy = "birdTypeID")
    private Set<Bird> birds = new LinkedHashSet<>();

}
