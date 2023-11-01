package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.TaskBirdFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskBirdFoodRepository extends JpaRepository<TaskBirdFood, Integer> {
    @Query(value = "delete from task_bird_food where taskBirdID = ?1",nativeQuery = true)
    void deleteByTaskBirdID(Integer id);
}
