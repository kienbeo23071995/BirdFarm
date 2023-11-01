package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task_bird_food")
public class TaskBirdFood {
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
    @JoinColumn(name = "taskBirdID", nullable = false)
    @JsonIgnore
    private TaskBird taskBirdID;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
