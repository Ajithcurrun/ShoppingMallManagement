package com.shoppingmall.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.entity.Customer;
import com.shoppingmall.service.ICustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> searchCustomerById(@PathVariable int id) {

        Customer customer = customerService.searchCustomerById(id);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {

        Boolean deleted = customerService.deleteCustomer(id);

        if (deleted) {
            return ResponseEntity.ok("Customer deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}