package com.shoppingmall.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.entity.Employee;
import com.shoppingmall.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> searchEmployeeById(@PathVariable int id) {

        Employee employee = employeeService.searchEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

        Boolean deleted = employeeService.deleteEmployee(id);

        if (deleted) {
            return ResponseEntity.ok("Employee deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}