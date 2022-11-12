package com.recipe.RecipeApp.controller;

import com.recipe.RecipeApp.entity.Employee;
import com.recipe.RecipeApp.entity.Grade;
import com.recipe.RecipeApp.service.EmployeeService;
import com.recipe.RecipeApp.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping(value = "/api/grades")
    public ResponseEntity<?> create(@RequestBody Grade grade) {
        gradeService.create(grade);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/grades")
    public ResponseEntity<?> findAll() {
        final List<Grade> gradeList = gradeService.findAll();

        return gradeList != null && !gradeList.isEmpty() ? new ResponseEntity<>(gradeList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/grades/{id}")
    public ResponseEntity<Optional<Grade>> find(@PathVariable(name = "id") Long id) {
        final Optional<Grade> grade = gradeService.find(id);

        return grade.isPresent() ? new ResponseEntity<>(grade, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/grades/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Grade> grade = gradeService.find(id);
        gradeService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
