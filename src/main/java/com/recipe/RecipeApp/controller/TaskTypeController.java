package com.recipe.RecipeApp.controller;

import com.recipe.RecipeApp.entity.TaskType;
import com.recipe.RecipeApp.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class TaskTypeController {
    private final TaskTypeService taskTypeService;

    @Autowired
    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @PostMapping(value = "/api/taskTypes")
    public ResponseEntity<?> create(@RequestBody TaskType taskType) {
        taskTypeService.create(taskType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/taskTypes")
    public ResponseEntity<?> findAll() {
        final List<TaskType> taskTypeList = taskTypeService.findAll();

        return taskTypeList != null && !taskTypeList.isEmpty() ? new ResponseEntity<>(taskTypeList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/taskTypes/{id}")
    public ResponseEntity<Optional<TaskType>> find(@PathVariable(name = "id") Long id) {
        final Optional<TaskType> taskType = taskTypeService.find(id);

        return taskType.isPresent() ? new ResponseEntity<>(taskType, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/taskTypes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<TaskType> taskType = taskTypeService.find(id);
        taskTypeService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
