package com.example.backend.controller;

import com.example.backend.model.Employee;
import com.example.backend.repository.EmployeeRepository;
import com.example.backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

//    @CrossOrigin("http://localhost:4200")
    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
