package com.recipe.RecipeApp.service;

import com.recipe.RecipeApp.entity.TaskStatus;
import com.recipe.RecipeApp.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskStatusService {

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    public void create(TaskStatus taskStatus) {
        taskStatusRepository.save(taskStatus);
    }

    public List<TaskStatus> findAll() {
        return taskStatusRepository.findAll();
    }


    public Optional<TaskStatus> find(Long id) {
        return taskStatusRepository.findById(id);
    }

    public void delete(Long id) {
        taskStatusRepository.deleteById(id);
    }
}

