package com.recipe.RecipeApp.controller;

import com.recipe.RecipeApp.entity.TaskPriority;
import com.recipe.RecipeApp.service.TaskPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class TaskPriorityController {
    private final TaskPriorityService taskPriorityService;

    @Autowired
    public TaskPriorityController(TaskPriorityService taskPriorityService) {
        this.taskPriorityService = taskPriorityService;
    }

    @PostMapping(value = "/api/taskPriorities")
    public ResponseEntity<?> create(@RequestBody TaskPriority taskPriority) {
        taskPriorityService.create(taskPriority);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/taskPriorities")
    public ResponseEntity<?> findAll() {
        final List<TaskPriority> taskPriorityList = taskPriorityService.findAll();

        return taskPriorityList != null && !taskPriorityList.isEmpty() ? new ResponseEntity<>(taskPriorityList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/taskPriorities/{id}")
    public ResponseEntity<Optional<TaskPriority>> find(@PathVariable(name = "id") Long id) {
        final Optional<TaskPriority> taskPriority = taskPriorityService.find(id);

        return taskPriority.isPresent() ? new ResponseEntity<>(taskPriority, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/taskPriorities/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<TaskPriority> taskPriority = taskPriorityService.find(id);
        taskPriorityService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
