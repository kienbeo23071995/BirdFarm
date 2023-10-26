package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @NotNull
    @Column(name = "age", nullable = false)
    private LocalDate age;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "image", nullable = false)
    private String image;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "birdTypeID", nullable = false)
    private BirdType birdTypeID;

    @OneToMany(mappedBy = "birdID")
    @JsonIgnore
    private Set<BirdCage> birdCages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "birdID")
    @JsonIgnore
    private Set<BirdStatus> birdStatuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "birdID")
    @JsonIgnore
    private Set<TaskBird> taskBirds = new LinkedHashSet<>();

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "attituteds", nullable = false)
    private String attituteds;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "qualities", nullable = false)
    private String qualities;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "color", nullable = false)
    private String color;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "appearance", nullable = false)
    private String appearance;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "exotic", nullable = false)
    private Boolean exotic;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "exoticrate")
    private String exoticrate;


}
