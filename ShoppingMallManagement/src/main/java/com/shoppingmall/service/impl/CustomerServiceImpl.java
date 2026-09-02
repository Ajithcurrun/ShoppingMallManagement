package com.shoppingmall.service.impl;

import org.springframework.stereotype.Service;

import com.shoppingmall.entity.Customer;
import com.shoppingmall.repository.ICustomerRepository;
import com.shoppingmall.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean deleteCustomer(int id) {

        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Customer searchCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }
}