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
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "color", nullable = false)
    private String color;

    @Nationalized
    @Lob
    @Column(name = "description")
    private String description;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private Set<TaskBird> taskBirds = new LinkedHashSet<>();

}
