package com.recipe.RecipeApp.repository;

import com.recipe.RecipeApp.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Boolean existsById(Integer id);
}
