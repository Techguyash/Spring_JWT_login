package com.coma.Billing.Data.service;

import java.time.LocalDate;
import java.util.List;

import com.coma.Billing.Data.model.CreateTaxRequest;
import com.coma.Entity.Tax;
import com.coma.ExceptionHandler.RunTimeException.BusinessApiException;
import com.coma.Repository.TaxRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService_Impl implements TaxService {

    @Autowired
    TaxRepo repo;

    @Override
    public Tax getTax(int id) {

        Tax foundTax = null;
        try {
            foundTax = repo.findById(id).get();
            return foundTax;
        } catch (Exception e) {
            e.printStackTrace();
            return foundTax;
        }

    }

    @Override
    public List<Tax> getAllTax() {

        return repo.findAll();
    }

    @Override
    public Tax updateTax(Tax tax) {

        Tax foundTax = null;
        try {

            foundTax = getTax(tax.getId());
            if (foundTax == null) {
                throw new BusinessApiException("Value is not available, Please create new");
            }

            foundTax.setTaxName(tax.getTaxName());
            foundTax.setDescription(tax.getDescription());
            foundTax.setPercentage(tax.getPercentage());
            repo.save(foundTax);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundTax;

    }

    @Override
    public boolean deleteTax(int id) {
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Tax createTax(CreateTaxRequest tax) {

        try {
            List<Tax> availableTax = getAllTax();

            for (Tax availTax : availableTax) {
                if (availTax.getTaxName().trim().equalsIgnoreCase(tax.getTaxName().trim())) {
                    throw new BusinessApiException("Value already availble");
                }
            }

            Tax entity = new Tax();
            entity.setTaxName(tax.getTaxName());
            entity.setCreatedAt(LocalDate.now());
            entity.setDescription(tax.getDescription());
            return repo.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
