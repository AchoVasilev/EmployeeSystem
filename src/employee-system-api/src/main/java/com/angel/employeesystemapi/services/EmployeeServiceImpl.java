package com.angel.employeesystemapi.services;

import com.angel.employeesystemapi.models.dto.Employee;
import com.angel.employeesystemapi.models.entities.EmployeeEntity;
import com.angel.employeesystemapi.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        var employeeEntity = new EmployeeEntity()
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmailId(employee.getEmailId());

        this.employeeRepository.save(employeeEntity);

        return employee
                .setId(employeeEntity.getId());
    }
}
