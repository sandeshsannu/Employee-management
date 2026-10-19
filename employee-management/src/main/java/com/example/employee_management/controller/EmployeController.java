package com.example.employee_management.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.service.EmployeService;

@RestController
@RequestMapping("/employees")
public class EmployeController {

	
	
	private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    // CREATE
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeService.addEmployee(employee); 
    }

    // READ ALL
    @GetMapping
    public List<Employee> getAllEmployees() {

        return employeService.getAllEmployes();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {

        return employeService.getEmployeeById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        return employeService.updateEmployee(id, employee);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        return employeService.deleteEmployee(id);
    }
	
}
