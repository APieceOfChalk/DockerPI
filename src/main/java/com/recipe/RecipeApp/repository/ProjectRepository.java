package com.recipe.RecipeApp.repository;

import com.recipe.RecipeApp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Boolean existsById(Integer id);
}
