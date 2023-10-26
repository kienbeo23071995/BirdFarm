package com.example.birdfarmprojectbe.service.impl;

import com.example.birdfarmprojectbe.models.TaskBird;
import com.example.birdfarmprojectbe.repository.BirdCageRepository;
import com.example.birdfarmprojectbe.repository.TaskBirdRepository;
import com.example.birdfarmprojectbe.service.TaskBirdService;
import com.example.birdfarmprojectbe.ulti.Helper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskBirdServiceImpl implements TaskBirdService {
    private final TaskBirdRepository taskBirdRepository;

    private final BirdCageRepository birdCageRepository;
    @Override
    public List<TaskBird> get(String startDate, String endDate) {
        List<TaskBird> list = taskBirdRepository.findAll();
        if(startDate != null && !startDate.trim().isEmpty()){
            list = list.stream().filter(taskBird -> taskBird.getStartDate().isBefore(Helper.convertStringToLocalDateTime(startDate)))
                    .collect(Collectors.toList());
        }
        if(endDate != null && !endDate.trim().isEmpty()){
            list = list.stream().filter(taskBird -> taskBird.getEndDate().isAfter(Helper.convertStringToLocalDateTime(endDate)))
                    .collect(Collectors.toList());
        }
        for(TaskBird i : list){
            Integer id = birdCageRepository.getBirdCageByBirdIDAndCageID(i.getBirdID().getId()).getCageID().getLocation().getId();
            i.setLocationID(id);
        }
        return list;
    }
}
