package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.TaskBirdMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskBirdMedicineRepository extends JpaRepository<TaskBirdMedicine, Integer> {
    @Query(value = "delete from task_bird_medicine where task_bird_ID = ?1",nativeQuery = true)
    void deleteByTaskBirdID(Integer id);
}
