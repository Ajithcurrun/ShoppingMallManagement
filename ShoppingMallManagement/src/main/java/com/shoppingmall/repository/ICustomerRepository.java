package com.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmall.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}