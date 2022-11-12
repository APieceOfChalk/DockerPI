package com.recipe.RecipeApp.controller;

import com.recipe.RecipeApp.entity.TaskStatus;
import com.recipe.RecipeApp.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class TaskStatusController {
    private final TaskStatusService taskStatusService;

    @Autowired
    public TaskStatusController(TaskStatusService taskStatusService) {
        this.taskStatusService = taskStatusService;
    }

    @PostMapping(value = "/api/taskStatuses")
    public ResponseEntity<?> create(@RequestBody TaskStatus taskStatus) {
        taskStatusService.create(taskStatus);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/taskStatuses")
    public ResponseEntity<?> findAll() {
        final List<TaskStatus> taskStatusList = taskStatusService.findAll();

        return taskStatusList != null && !taskStatusList.isEmpty() ? new ResponseEntity<>(taskStatusList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/taskStatuses/{id}")
    public ResponseEntity<Optional<TaskStatus>> find(@PathVariable(name = "id") Long id) {
        final Optional<TaskStatus> taskStatus = taskStatusService.find(id);

        return taskStatus.isPresent() ? new ResponseEntity<>(taskStatus, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/taskStatuses/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<TaskStatus> taskStatus = taskStatusService.find(id);
        taskStatusService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
