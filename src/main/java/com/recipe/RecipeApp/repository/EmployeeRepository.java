package com.recipe.RecipeApp.repository;

import com.recipe.RecipeApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    List<Employee> findByNickname(String nickname);

    Boolean existsById(Integer id);
}
