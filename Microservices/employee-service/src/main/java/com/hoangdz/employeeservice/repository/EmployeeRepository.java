package com.hoangdz.employeeservice.repository;

import com.hoangdz.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();
    public List<Employee> findAll() {
        return employees;
    }
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }
    public Employee findById(Long id) {
        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }
    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .collect(Collectors.toList());
    }
}
