package com.example.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class EmployeService {
	private final EmployeeRepository employeRepository;

    public EmployeService(EmployeeRepository employeeRepository) {
        this.employeRepository = employeeRepository;
    }
    
   // public EmployeeRepository employeeRepository;
    

    // CREATE
    public Employee addEmployee(Employee employee) {

        return employeRepository.save(employee);
    }

    // READ ALL
    public List<Employee> getAllEmployes() {
    	
   

        return employeRepository.findAll();
    }

    // READ ONE
    public Employee getEmployeeById(Long id) {

        return employeRepository.findById(id)
                .orElse(null);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee =
                employeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {

            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());

            return employeRepository.save(existingEmployee);
        }

        return null;
    }

    // DELETE
    public String deleteEmployee(Long id) {

        if (employeRepository.existsById(id)) {

            employeRepository.deleteById(id);

            return "Employee deleted successfully";
        }

        return "Employee not found";
    }
}
