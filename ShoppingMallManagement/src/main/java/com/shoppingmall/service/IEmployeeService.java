package com.shoppingmall.service;

import com.shoppingmall.entity.Employee;

public interface IEmployeeService {

    Boolean addEmployee(Employee employee);

    Boolean updateEmployee(Employee employee);

    Employee searchEmployeeById(int id);

    Boolean deleteEmployee(int id);
}