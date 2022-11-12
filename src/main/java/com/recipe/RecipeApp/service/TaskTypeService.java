package com.recipe.RecipeApp.service;

import com.recipe.RecipeApp.entity.TaskType;
import com.recipe.RecipeApp.repository.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskTypeService {

    @Autowired
    private TaskTypeRepository taskTypeRepository;

    public void create(TaskType taskType) {
        taskTypeRepository.save(taskType);
    }

    public List<TaskType> findAll() {
        return taskTypeRepository.findAll();
    }


    public Optional<TaskType> find(Long id) {
        return taskTypeRepository.findById(id);
    }

    public void delete(Long id) {
        taskTypeRepository.deleteById(id);
    }
}

