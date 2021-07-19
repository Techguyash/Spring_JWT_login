package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Entity.Customer;
import com.coma.Repository.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService_Impl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer createCustomer(Customer req) {
       
        try {
        List<Customer> availableCustomer = getAllCustomers();
        for (Customer cust : availableCustomer) {
          if (cust.getMobile().equals(req.getMobile())) {
            throw new Exception("value already availble");
          }
        }
           return customerRepo.save(req);

       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
    }

    @Override
    public Customer getCustomer(long id) {
        try {
           return customerRepo.getById(id);
        } catch (Exception e) {
           e.printStackTrace();
           return null;

        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try {
            return customerRepo.findAll();
           
        } catch (Exception e) {
           
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Customer updateCustomer(Customer category) {
        Customer entity =null;
        try {

          entity = customerRepo.findById(category.getCustomerId()).get();
            if(entity==null)
            {
                throw new Exception("value not available");
            }
            entity.setAddress(category.getAddress());
            entity.setDob(category.getDob());
            entity.setEmail(category.getEmail());
            entity.setMobile(category.getMobile());
            entity.setName(category.getName());
            return customerRepo.save(entity);
        
        } catch (Exception e) {
            e.printStackTrace();
            return entity;
        }
    }

    @Override
    public boolean deleteCustomer(long id) {
        try {
           customerRepo.deleteById(id);
           return true;
        } catch (Exception e) {
           
            e.printStackTrace();
            return false;
        }
    }
    
}
