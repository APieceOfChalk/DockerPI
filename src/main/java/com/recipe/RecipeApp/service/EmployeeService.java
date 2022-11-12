package com.recipe.RecipeApp.service;

import com.recipe.RecipeApp.entity.Employee;
import com.recipe.RecipeApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void create(Employee employee) {
        employeeRepository.save(employee);
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    public Optional<Employee> find(Long id) {
        return employeeRepository.findById(id);
    }


//    public List<Employee> findByName(String nickname){
//        return employeeRepository.findByNickname(nickname);
//    }

//    public List<Employee> update(Employee employee) {
//        var updatedUser = employeeRepository.findById(employee.getId());
//
//        if (updatedUser.isPresent()) {
//            var updatedUser_ = updatedUser.get();
//
//            updatedUser_.setNickname(employee.getNickname() != null ? employee.getNickname() : updatedUser_.getNickname());
//            updatedUser_.setEmail(employee.getEmail() != null ? employee.getEmail() : updatedUser_.getEmail());
//            updatedUser_.setPassword(employee.getPassword() != null ? employee.getPassword() : updatedUser_.getPassword());
//
//            employeeRepository.save(updatedUser_);
//        }
//        return employeeRepository.findAll();
//    }


    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}

