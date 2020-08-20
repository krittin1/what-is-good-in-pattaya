package com.pattaya.group1.web_service.controller;

import com.pattaya.group1.web_service.entity.Employee;
import com.pattaya.group1.web_service.exception.EmployeeNotFound;
import com.pattaya.group1.web_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final Logger logger = Logger.getLogger(UsersController.class.getName());
    @Autowired
    private EmployeeRepository employeeRepository;

    // Helper endpoints for debugging only
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable(required = true) String id) {
        Employee employee = employeeRepository.findByUserId(id);
        if (employee == null) {
            throw new EmployeeNotFound("Cannot find the user whose id is `" + id + "` in the database.");
        }
        return employee;
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
