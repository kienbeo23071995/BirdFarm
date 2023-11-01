package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.api.error.BadRequestAlertException;
import com.example.birdfarmprojectbe.dto.*;
import com.example.birdfarmprojectbe.models.Task;
import com.example.birdfarmprojectbe.models.TaskBird;
import com.example.birdfarmprojectbe.models.TaskBirdFood;
import com.example.birdfarmprojectbe.models.TaskBirdMedicine;
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
    private final FoodNormRepository foodNormRepository;
    private final TaskBirdFoodRepository taskBirdFoodRepository;
    private final TaskBirdMedicineRepository taskBirdMedicineRepository;
    private final CageRepository cageRepository;
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
        task.setAccount(accountRepository.findById(taskDTO.getAccountID()).get());
        task.setTitle(taskDTO.getTitle());
        task.setColor(taskDTO.getColor());
        task.setDescription(taskDTO.getDescription());
        taskRepository.save(task);
        for(CageTaskDTO i : taskDTO.getCageTaskDTOList()){
            for(ScheduleDTO item : i.getSchedules()){
                TaskBird taskBird = new TaskBird();
                taskBird.setStartDate(Helper.convertStringToLocalDateTime(item.getStartDate()));
                taskBird.setEndDate(Helper.convertStringToLocalDateTime(item.getEndDate()));
                taskBird.setStatus(item.getStatus());
                if(item.getStaffID() != null){
                    taskBird.setStaffid(accountRepository.findById(item.getStaffID()).get());
                }
                taskBird.setStaffid(accountRepository.findById(item.getStaffID()).get());
                taskBird.setNote(item.getNote());
                taskBird.setCageid(cageRepository.findById(i.getCageID()).get());
                taskBird.setTask(task);
                if(i.getFoodNormID() != null){
                    taskBird.setFoodNormID(foodNormRepository.findById(i.getFoodNormID()).get());
                }
                taskBirdRepository.save(taskBird);
                if(item.getFoodList() != null){
                    for(FoodNormFoodDTO temp : item.getFoodList()){
                        TaskBirdFood taskBirdFood = new TaskBirdFood();
                        taskBirdFood.setTaskBirdID(taskBird);
                        taskBirdFood.setQuantity(temp.getQuantity());
                        taskBirdFood.setFoodTypeID(temp.getFoodType());
                        taskBirdFoodRepository.save(taskBirdFood);
                    }
                }
                if(item.getMedicineList() != null){
                    for(FoodNormMedicineDTO temp : item.getMedicineList()){
                        TaskBirdMedicine taskBirdMedicine = new TaskBirdMedicine();
                        taskBirdMedicine.setTaskBird(taskBird);
                        taskBirdMedicine.setQuantity(temp.getQuantity());
                        taskBirdMedicine.setMedicineID(temp.getMedicine());
                        taskBirdMedicineRepository.save(taskBirdMedicine);
                    }
                }
            }
        }
        return ResponseEntity.ok(taskBirdService.get(null,null));
    }

    @PutMapping(value = "/updateInfoTaskBird/{id}")
    public ResponseEntity<TaskBird> update(@PathVariable final Integer id,@RequestBody TaskBird taskBird,
                                           @RequestBody(required = false) List<TaskBirdFood> foodList,
                                           @RequestBody(required = false) List<TaskBirdMedicine> medicineList) throws ParseException
    {
        if (!Objects.equals(id, taskBird.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!taskBirdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        TaskBird result = taskBirdRepository.save(taskBird);
        taskBirdFoodRepository.deleteByTaskBirdID(taskBird.getId());
        taskBirdFoodRepository.saveAll(foodList);
        taskBirdMedicineRepository.deleteByTaskBirdID(taskBird.getId());
        taskBirdMedicineRepository.saveAll(medicineList);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PutMapping(value = "/deleteTaskBird/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id)
    {
        taskBirdFoodRepository.deleteByTaskBirdID(id);
        taskBirdMedicineRepository.deleteByTaskBirdID(id);
        taskBirdRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
