package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bird")
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "age", nullable = false)
    private LocalDate age;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bird_typeid", nullable = false)
    private BirdType birdTypeid;

    @NotNull
    @Column(name = "exotic", nullable = false)
    private Boolean exotic = false;

    @NotNull
    @Column(name = "gender", nullable = false)
    private Boolean gender = false;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "appearance", nullable = false)
    private String appearance;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "attituteds", nullable = false)
    private String attituteds;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "color", nullable = false)
    private String color;

    @Nationalized
    @Lob
    @Column(name = "exoticrate")
    private String exoticrate;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "image", nullable = false)
    private String image;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "qualities", nullable = false)
    private String qualities;

    @OneToMany(mappedBy = "birdid")
    @JsonIgnore
    private Set<BirdCage> birdCages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "birdid")
    @JsonIgnore
    private Set<BirdStatus> birdStatuses = new LinkedHashSet<>();

}
