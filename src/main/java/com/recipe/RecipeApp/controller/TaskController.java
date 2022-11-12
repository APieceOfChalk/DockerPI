package com.recipe.RecipeApp.controller;

import com.recipe.RecipeApp.entity.Task;
import com.recipe.RecipeApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/api/tasks")
    public ResponseEntity<?> create(@RequestBody Task task) {
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/tasks")
    public ResponseEntity<?> findAll() {
        final List<Task> taskList = taskService.findAll();

        return taskList != null && !taskList.isEmpty() ? new ResponseEntity<>(taskList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/tasks/{id}")
    public ResponseEntity<Optional<Task>> find(@PathVariable(name = "id") Long id) {
        final Optional<Task> task = taskService.find(id);

        return task.isPresent() ? new ResponseEntity<>(task, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Task> task = taskService.find(id);
        taskService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
