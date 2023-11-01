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
@Table(name = "cage")
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bird_typeid", nullable = false)
    private BirdType birdTypeid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locationid", nullable = false)
    private Location locationid;

    @NotNull
    @Column(name = "\"max\"", nullable = false)
    private Integer max;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "image", nullable = false)
    private String image;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "cageid")
    @JsonIgnore
    private Set<BirdCage> birdCages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cageid")
    @JsonIgnore
    private Set<TaskBird> taskBirds = new LinkedHashSet<>();

}
