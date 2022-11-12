package com.recipe.RecipeApp.repository;

import com.recipe.RecipeApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Boolean existsById(Integer id);
}
