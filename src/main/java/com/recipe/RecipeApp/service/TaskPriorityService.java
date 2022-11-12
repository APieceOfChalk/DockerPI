package com.recipe.RecipeApp.service;

import com.recipe.RecipeApp.entity.TaskPriority;
import com.recipe.RecipeApp.repository.TaskPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskPriorityService {

    @Autowired
    private TaskPriorityRepository taskPriorityRepository;

    public void create(TaskPriority taskPriority) {
        taskPriorityRepository.save(taskPriority);
    }

    public List<TaskPriority> findAll() {
        return taskPriorityRepository.findAll();
    }


    public Optional<TaskPriority> find(Long id) {
        return taskPriorityRepository.findById(id);
    }

    public void delete(Long id) {
        taskPriorityRepository.deleteById(id);
    }
}

