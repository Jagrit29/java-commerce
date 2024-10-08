package com.personalprojects.java_commerce.controllers;

// Operations
// /employees
// Get Employee
// Post Employee
// Update Employee
// Delete Employee


import com.personalprojects.java_commerce.dto.EmployeeDTO;
import com.personalprojects.java_commerce.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path ="/employees")
public class EmployeeController {

    // now make mapping for all;
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);

    }

}




// Notes
/*
// http://localhost:8080/employees?sortBy=color&limit=2
1. Use annotoation controller specifically REST API Controller to make the class the controller
2. Data return from DTO is automatically converted into Json data ( Serialisation and desiration)
3. JSON to JavaObject and JavaObject to JSON  ( Done by Jackson )


// How to add Filters?
// get employee by name etc

Path variable is a required thing in the path
Path param is an optional


*/