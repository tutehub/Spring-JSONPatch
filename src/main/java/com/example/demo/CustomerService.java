package com.example.demo;/**
 * Created by TUTEHUB on 2021/7/2 6:10 PM.
 * Copyright © 2021 TUTEHUB. All rights reserved.
 * ------------------------
 * Non-disclosure Terms
 * -------------------------
 * These codes are TUTEHUB's property, as the developer, such as employee, contractor, and intern, working for TUTEHUB cannot disclose, spread, copy, preserve, sell, and do other activities without the consent of TUTEHUB.
 * Developer dph agrees with above terms.
 * Technique Support: jobyme88.com
 * Contact: noreply@fengcaoculture.com
 */


/**
 * @description
 */

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Optional<Customer> findCustomer(String id);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer oldCustomer, Customer newCustomer);
}