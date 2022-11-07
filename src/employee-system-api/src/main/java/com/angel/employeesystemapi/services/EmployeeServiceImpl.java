package com.angel.employeesystemapi.services;

import com.angel.employeesystemapi.models.dto.Employee;
import com.angel.employeesystemapi.models.entities.EmployeeEntity;
import com.angel.employeesystemapi.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        var employeeEntity = new EmployeeEntity()
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmailId(employee.getEmailId());

        this.employeeRepository.save(employeeEntity);

        return employee
                .setId(employeeEntity.getId());
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll()
                .stream()
                .map(entity -> new Employee()
                        .setId(entity.getId())
                        .setEmailId(entity.getEmailId())
                        .setFirstName(entity.getFirstName())
                        .setLastName(entity.getLastName()))
                .toList();
    }

    public boolean deleteEmployee(Long employeeId) {
        var employee = this.employeeRepository.findById(employeeId).get();

        this.employeeRepository.delete(employee);

        return true;
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return this.employeeRepository.findById(employeeId)
                .map(employee -> new Employee().setId(employee.getId())
                        .setFirstName(employee.getFirstName())
                        .setLastName(employee.getLastName())
                        .setEmailId(employee.getEmailId()));
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {
        var employeeEntity = this.employeeRepository.findById(employeeId).get();

        employeeEntity.setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmailId(employee.getEmailId());

        this.employeeRepository.save(employeeEntity);

        return employee;
    }
}
