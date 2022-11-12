package com.recipe.RecipeApp.controller;

import com.recipe.RecipeApp.entity.Grade;
import com.recipe.RecipeApp.entity.Job;
import com.recipe.RecipeApp.service.GradeService;
import com.recipe.RecipeApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(value = "/api/jobs")
    public ResponseEntity<?> create(@RequestBody Job job) {
        jobService.create(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/jobs")
    public ResponseEntity<?> findAll() {
        final List<Job> jobList = jobService.findAll();

        return jobList != null && !jobList.isEmpty() ? new ResponseEntity<>(jobList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/jobs/{id}")
    public ResponseEntity<Optional<Job>> find(@PathVariable(name = "id") Long id) {
        final Optional<Job> job = jobService.find(id);

        return job.isPresent() ? new ResponseEntity<>(job, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/jobs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Job> job = jobService.find(id);
        jobService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
