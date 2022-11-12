package com.recipe.RecipeApp.controller;

import com.recipe.RecipeApp.entity.Project;
import com.recipe.RecipeApp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(value = "/api/projects")
    public ResponseEntity<?> create(@RequestBody Project project) {
        projectService.create(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/projects")
    public ResponseEntity<?> findAll() {
        final List<Project> projectList = projectService.findAll();

        return projectList != null && !projectList.isEmpty() ? new ResponseEntity<>(projectList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/projects/{id}")
    public ResponseEntity<Optional<Project>> find(@PathVariable(name = "id") Long id) {
        final Optional<Project> project = projectService.find(id);

        return project.isPresent() ? new ResponseEntity<>(project, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/projects/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Project> project = projectService.find(id);
        projectService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
