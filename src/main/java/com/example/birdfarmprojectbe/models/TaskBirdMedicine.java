package com.example.birdfarmprojectbe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task_bird_medicine")
public class TaskBirdMedicine {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medicineID", nullable = false)
    private Medicine medicineID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_bird_ID", nullable = false)
    private TaskBird taskBird;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
