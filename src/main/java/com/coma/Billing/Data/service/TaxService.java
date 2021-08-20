package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Billing.Data.model.CreateTaxRequest;
import com.coma.Entity.Tax;

public interface TaxService {
    
    Tax createTax(CreateTaxRequest tax);
    Tax getTax(int id);
    List<Tax> getAllTax();
    Tax updateTax(Tax tax);
    boolean deleteTax(int Id);
}
