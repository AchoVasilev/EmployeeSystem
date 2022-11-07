package com.angel.employeesystemapi.controllers;

import com.angel.employeesystemapi.models.dto.Employee;
import com.angel.employeesystemapi.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable("id") Long employeeId) {
        var deleted = false;

        deleted = this.employeeService.deleteEmployee(employeeId);

        var response = new HashMap<String, Boolean>();
        response.put("deleted", deleted);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
        var employee = this.employeeService.getEmployeeById(employeeId);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }

        return ResponseEntity.notFound()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee employee) {
        var updated = this.employeeService.updateEmployee(employeeId, employee);

        return ResponseEntity.ok(updated);
    }
}
