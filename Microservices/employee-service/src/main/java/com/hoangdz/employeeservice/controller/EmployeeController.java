package com.hoangdz.employeeservice.controller;

import com.hoangdz.employeeservice.model.Employee;
import com.hoangdz.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeRepository employeeRepository;
    @PostMapping()
    public Employee addEmployee(@ RequestBody Employee employee) {
        return employeeRepository.addEmployee(employee);
    }
    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable  Long id) {
        return employeeRepository.findById(id);
    }
    @GetMapping("/department/{id}")
    public List<Employee> getEmployeeByDepartmentId(@PathVariable Long id) {
        return employeeRepository.findByDepartment(id);
    }
}
