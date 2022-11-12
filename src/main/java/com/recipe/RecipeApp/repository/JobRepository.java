package com.recipe.RecipeApp.repository;

import com.recipe.RecipeApp.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    Boolean existsById(Integer id);
}
