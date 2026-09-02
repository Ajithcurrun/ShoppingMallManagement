package com.shoppingmall.service.impl;

import org.springframework.stereotype.Service;

import com.shoppingmall.entity.Employee;
import com.shoppingmall.repository.IEmployeeRepository;
import com.shoppingmall.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public Employee searchEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }

        return false;
    }
}