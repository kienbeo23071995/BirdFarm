package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.dto.BirdDTO;
import com.example.birdfarmprojectbe.dto.TaskDTO;
import com.example.birdfarmprojectbe.models.Bird;
import com.example.birdfarmprojectbe.models.BirdCage;
import com.example.birdfarmprojectbe.models.Task;
import com.example.birdfarmprojectbe.models.TaskBird;
import com.example.birdfarmprojectbe.repository.*;
import com.example.birdfarmprojectbe.service.FileUpload;
import com.example.birdfarmprojectbe.ulti.Helper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.Instant;
import java.util.*;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/schedule")
@AllArgsConstructor
public class ScheduleAPI {
    private final String ENTITY_NAME = "ScheduleAPI";

    private final TaskRepository taskRepository;

    private final BirdRepository birdRepository;
    private final FoodTypeRepository foodTypeRepository;
    private final TaskBirdRepository taskBirdRepository;

    @GetMapping("/getall")
    public ResponseEntity<List<TaskBird>> getAll(){
        return ResponseEntity.ok(taskBirdRepository.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<TaskBird>> save(@RequestBody TaskDTO taskDTO) throws ParseException {
        Task task = new Task();
        task.setTitle(task.getTitle());
        task.setColor(task.getColor());
        task.setDescription(task.getDescription());
        taskRepository.save(task);
        for(BirdDTO i : taskDTO.getBirdDTOList()){
            for(String item : i.getSchedules()){
                TaskBird taskBird = new TaskBird();
                taskBird.setDate(Helper.convertStringToInstant(item));
                taskBird.setBirdID(birdRepository.findById(i.getBirdID()).get());
                taskBird.setQuantity(i.getQuantity());
                taskBird.setFoodTypeID(foodTypeRepository.findById(i.getFoodTypeID()).get());
                taskBird.setTask(task);
                taskBirdRepository.save(taskBird);
            }
        }
        return ResponseEntity.ok(taskBirdRepository.findAll());
    }

    @PutMapping(value = "/updateInfoTaskBird/{id}")
    public ResponseEntity<TaskBird> update(@PathVariable final Integer id,@RequestBody TaskBird taskBird) throws ParseException
    {
        if (!Objects.equals(id, taskBird.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!taskBirdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        TaskBird result = taskBirdRepository.save(taskBird);
        return ResponseEntity
                .ok()
                .body(result);
    }


}
