package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.TaskBird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskBirdRepository extends JpaRepository<TaskBird, Integer> {
}
