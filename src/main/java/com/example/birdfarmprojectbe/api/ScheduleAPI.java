package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.dto.BirdDTO;
import com.example.birdfarmprojectbe.dto.ScheduleDTO;
import com.example.birdfarmprojectbe.dto.TaskDTO;
import com.example.birdfarmprojectbe.models.Task;
import com.example.birdfarmprojectbe.models.TaskBird;
import com.example.birdfarmprojectbe.repository.*;
import com.example.birdfarmprojectbe.service.TaskBirdService;
import com.example.birdfarmprojectbe.ulti.Helper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.*;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/schedule")
@AllArgsConstructor
public class ScheduleAPI {
    private final String ENTITY_NAME = "ScheduleAPI";

    private final TaskRepository taskRepository;

    private final AccountRepository accountRepository;

    private final BirdRepository birdRepository;
    private final FoodTypeRepository foodTypeRepository;
    private final TaskBirdRepository taskBirdRepository;
    private final TaskBirdService taskBirdService;

    @GetMapping("/getall")
    public ResponseEntity<List<TaskBird>> getAll(@RequestParam(value = "startDate",required = false) String startDate,
                                                 @RequestParam(value = "endDate",required = false) String endDate){
        return ResponseEntity.ok(taskBirdService.get(startDate,endDate));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<TaskBird>> save(@RequestBody TaskDTO taskDTO) throws ParseException {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setColor(taskDTO.getColor());
        task.setDescription(taskDTO.getDescription());
        taskRepository.save(task);
        for(BirdDTO i : taskDTO.getBirdDTOList()){
            for(ScheduleDTO item : i.getSchedules()){
                TaskBird taskBird = new TaskBird();
                taskBird.setStartDate(Helper.convertStringToLocalDateTime(item.getStartDate()));
                taskBird.setEndDate(Helper.convertStringToLocalDateTime(item.getEndDate()));
                taskBird.setStatus(item.getStatus());
                taskBird.setStaff(accountRepository.findById(item.getStaffID()).get());
                taskBird.setNote(item.getNote());
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

    @PutMapping(value = "/deleteTaskBird/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id)
    {
        taskBirdRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
