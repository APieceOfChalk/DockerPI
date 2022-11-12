package com.recipe.RecipeApp.controller;

import com.recipe.RecipeApp.entity.Employee;
import com.recipe.RecipeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/api/employees")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        employeeService.create(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/employees")
    public ResponseEntity<?> findAll() {
        final List<Employee> employeeList = employeeService.findAll();

        return employeeList != null && !employeeList.isEmpty() ? new ResponseEntity<>(employeeList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/employees/{id}")
    public ResponseEntity<Optional<Employee>> find(@PathVariable(name = "id") Long id) {
        final Optional<Employee> user = employeeService.find(id);

        return user.isPresent() ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/api/users/userName-{nickname}")
//    public ResponseEntity<List<Employee>> findByName(@PathVariable(name = "nickname") String nickname){
//        final List<Employee> employeeList = employeeService.findByName(nickname);
//        return employeeList != null && !employeeList.isEmpty()
//                ? new ResponseEntity<>(employeeList, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @PutMapping("/api/users/{id}")
//    public ResponseEntity<List<Employee>> update(@RequestBody Employee employee) {
//        final List<Employee> employeeList = employeeService.update(employee);
//
//        return new ResponseEntity<>(employeeList, HttpStatus.OK);
//    }

    @DeleteMapping(value = "/api/employees/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Employee> user = employeeService.find(id);
        employeeService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
