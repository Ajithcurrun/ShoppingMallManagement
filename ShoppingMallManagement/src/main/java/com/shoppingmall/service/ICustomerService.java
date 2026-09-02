package com.shoppingmall.service;

import com.shoppingmall.entity.Customer;

public interface ICustomerService {

    Customer addCustomer(Customer customer);

    Boolean deleteCustomer(int id);

    Customer searchCustomerById(int id);
}