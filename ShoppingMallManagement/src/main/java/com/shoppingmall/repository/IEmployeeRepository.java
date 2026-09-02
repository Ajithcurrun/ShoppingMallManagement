
package com.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmall.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
