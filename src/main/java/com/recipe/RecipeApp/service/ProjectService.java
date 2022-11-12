package com.recipe.RecipeApp.service;

import com.recipe.RecipeApp.entity.Project;
import com.recipe.RecipeApp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void create(Project project) {
        projectRepository.save(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }


    public Optional<Project> find(Long id) {
        return projectRepository.findById(id);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}

