package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.TaskBird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskBirdRepository extends JpaRepository<TaskBird, Integer>{
}
