package com.recipe.RecipeApp.service;

import com.recipe.RecipeApp.entity.Employee;
import com.recipe.RecipeApp.entity.Grade;
import com.recipe.RecipeApp.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public void create(Grade grade) {
        gradeRepository.save(grade);
    }


    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }


    public Optional<Grade> find(Long id) {
        return gradeRepository.findById(id);
    }

    public void delete(Long id) {
        gradeRepository.deleteById(id);
    }
}

