package com.angel.employeesystemapi.services;

import com.angel.employeesystemapi.models.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long employeeId);
}
