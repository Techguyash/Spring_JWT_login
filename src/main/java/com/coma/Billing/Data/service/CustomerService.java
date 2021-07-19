package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Entity.Customer;

public interface CustomerService {

    Customer createCustomer(Customer category);
    Customer getCustomer(long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer category);
    boolean deleteCustomer(long Id);
    
}
