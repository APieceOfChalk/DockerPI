package com.recipe.RecipeApp.repository;

import com.recipe.RecipeApp.entity.Job;
import com.recipe.RecipeApp.entity.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {
    Boolean existsById(Integer id);
}
