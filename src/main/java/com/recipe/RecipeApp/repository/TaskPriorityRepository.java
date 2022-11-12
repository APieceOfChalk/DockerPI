package com.recipe.RecipeApp.repository;

import com.recipe.RecipeApp.entity.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long> {
    Boolean existsById(Integer id);
}
