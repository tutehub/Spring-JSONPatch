package com.example.demo;/**
 * Created by TUTEHUB on 2021/7/2 6:17 PM.
 * Copyright © 2021 TUTEHUB. All rights reserved.
 * ------------------------
 * Non-disclosure Terms
 * -------------------------
 * These codes are TUTEHUB's property, as the developer, such as employee, contractor, and intern, working for TUTEHUB cannot disclose, spread, copy, preserve, sell, and do other activities without the consent of TUTEHUB.
 * Developer dph agrees with above terms.
 * Technique Support: jobyme88.com
 * Contact: noreply@fengcaoculture.com
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @description
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerIdGenerator customerIdGenerator;
    private List<Customer> customers = new ArrayList<>();

    @Autowired
    public CustomerServiceImpl(CustomerIdGenerator customerIdGenerator) {
        this.customerIdGenerator = customerIdGenerator;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setId(Integer.toString(customerIdGenerator.generateNextId()));
        System.out.println("Shark " + customer.getId());
        customers.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findCustomer(String id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public void updateCustomer(Customer oldCustomer, Customer newCustomer) {
        customers.set(customers.indexOf(oldCustomer), newCustomer);
    }


}
