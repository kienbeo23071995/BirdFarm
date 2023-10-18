package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
