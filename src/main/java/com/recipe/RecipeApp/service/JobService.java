package com.recipe.RecipeApp.service;

import com.recipe.RecipeApp.entity.Grade;
import com.recipe.RecipeApp.entity.Job;
import com.recipe.RecipeApp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public void create(Job job) {
        jobRepository.save(job);
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }


    public Optional<Job> find(Long id) {
        return jobRepository.findById(id);
    }

    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}

