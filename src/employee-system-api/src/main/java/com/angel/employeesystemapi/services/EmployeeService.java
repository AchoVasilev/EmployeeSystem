package com.angel.employeesystemapi.services;

import com.angel.employeesystemapi.models.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long employeeId);

    Optional<Employee> getEmployeeById(Long employeeId);

    Employee updateEmployee(Long employeeId, Employee employee);
}
