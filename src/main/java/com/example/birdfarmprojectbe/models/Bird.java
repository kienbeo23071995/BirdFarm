package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
    @JsonManagedReference
    private BirdType birdTypeID;

    @OneToMany(mappedBy = "birdID")
    @JsonBackReference
    private Set<BirdCage> birdCages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "birdID")
    @JsonBackReference
    private Set<BirdStatus> birdStatuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "birdID")
    @JsonBackReference
    private Set<TaskBird> taskBirds = new LinkedHashSet<>();

    @OneToMany(mappedBy = "birdID")
    @JsonBackReference
    private Set<BirdMedicine> birdMedicines = new LinkedHashSet<>();
}
