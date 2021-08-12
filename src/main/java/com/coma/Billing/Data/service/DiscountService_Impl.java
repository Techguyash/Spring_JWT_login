package com.coma.Billing.Data.service;

import java.time.LocalDate;
import java.util.List;

import com.coma.Billing.Data.model.CreateDiscountRequest;
import com.coma.Entity.Discount;
import com.coma.ExceptionHandler.RunTimeException.BusinessApiException;
import com.coma.Repository.DiscountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DiscountService_Impl implements DiscountService{

    @Autowired
    DiscountRepo repo;

    @Override
    public Discount createDiscount(CreateDiscountRequest req) {
        
        try {
            List<Discount> availableDiscount = getAllDiscounts();

            if(availableDiscount!=null)
            {
            for (Discount availDiscount : availableDiscount) {
                if (availDiscount.getDiscountName().trim().equalsIgnoreCase(req.getDiscountName().trim())) 
                {
                    throw new Exception("Value already availble");
                }
            }
        }
            Discount entity = new Discount();
            entity.setDiscountName(req.getDiscountName());
            entity.setCreatedAt(LocalDate.now());
            entity.setDescription(req.getDescription());
            entity.setPercentageVal(req.getPercentage());
            return repo.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    @Override
    public Discount getDiscount(int id) {
        
        Discount foundDiscount = null;
        try {
            foundDiscount = repo.findById(id).get();
            return foundDiscount;
        } catch (Exception e) {
            e.printStackTrace();
            return foundDiscount;
        }
    }

    @Override
    public List<Discount> getAllDiscounts() {
        return repo.findAll();
    }

    @Override
    public Discount updateDiscount(Discount discount) {
        
        Discount foundDiscount = null;
        try {

            foundDiscount = getDiscount(discount.getId());
            if (foundDiscount == null) {
                throw new BusinessApiException("Value is not available, Please create new");
            }

            foundDiscount.setDiscountName(discount.getDiscountName());
            foundDiscount.setDescription(discount.getDescription());
            foundDiscount.setPercentageVal(discount.getPercentageVal());
            foundDiscount.setEnabled(discount.getEnabled());
            repo.save(foundDiscount);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundDiscount;
    }

    @Override
    public boolean deleteDiscount(int id) {
        
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
