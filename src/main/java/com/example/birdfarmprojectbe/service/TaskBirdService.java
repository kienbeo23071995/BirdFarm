package com.example.birdfarmprojectbe.service;

import com.example.birdfarmprojectbe.models.TaskBird;

import java.util.List;

public interface TaskBirdService {
    public List<TaskBird> get(String startDate, String endDate);
}
