package com.example.birdfarmprojectbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "account_name", nullable = false)
    private String accountName;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "staff")
    @JsonIgnore
    private Set<TaskBird> taskBirds = new LinkedHashSet<>();

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<Task> tasks = new LinkedHashSet<>();

}
