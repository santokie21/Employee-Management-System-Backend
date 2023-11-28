package com.example.backend.services;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Employee;
import com.example.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    public ResponseEntity<Employee> getEmployeeById(long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with id " + id));
        return ResponseEntity.ok(employee);
    }

    public ResponseEntity<Employee> updateEmployee(Long id, Employee employeeDetails) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with id " + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        Employee updateEmployee=employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }

    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with id " + id));
        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted!",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

