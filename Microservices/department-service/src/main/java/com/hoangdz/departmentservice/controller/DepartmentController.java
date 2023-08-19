package com.hoangdz.departmentservice.controller;

import com.hoangdz.departmentservice.client.EmployeeClient;
import com.hoangdz.departmentservice.model.Department;
import com.hoangdz.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @GetMapping()
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping()
    public Department addDepartment(@RequestBody Department department) {
        return departmentRepository.addDepartments(department);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> getAllDepartmentsWithEmployees() {
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.getEmployeeByDepartmentId(department.getId())));
        return departments;
    }
}
