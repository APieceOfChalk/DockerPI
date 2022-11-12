package com.recipe.RecipeApp.repository;

import com.recipe.RecipeApp.entity.TaskStatus;
import com.recipe.RecipeApp.entity.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
    Boolean existsById(Integer id);
}
