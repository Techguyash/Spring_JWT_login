package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Entity.Vendor;
import com.coma.Repository.VendorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService_Impl implements VendorService{

    @Autowired
    VendorRepo vendorRepo;

    @Override
    public Vendor createVendor(Vendor req) {
      
        try {
            List<Vendor> availableVendor = getAllVendors();
            for (Vendor vend : availableVendor) {
              if (vend.getMobile().equals(req.getMobile())) {
                throw new Exception("value already available");
              }
            }
               return vendorRepo.save(req);
    
           } catch (Exception e) {
               e.printStackTrace();
               return null;
           }
        }

    @Override
    public Vendor getVendor(long id) {
      
        try {
            return vendorRepo.getById(id);
         } catch (Exception e) {
            e.printStackTrace();
            return null;
 
         }
    }

    @Override
    public List<Vendor> getAllVendors() {
        try {
            return vendorRepo.findAll();
           
        } catch (Exception e) {
           
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Vendor updateVendor(Vendor vendor) {
        Vendor entity =null;
        try {

          entity = vendorRepo.findById(vendor.getVendorId()).get();
            if(entity==null)
            {
                throw new Exception("value not available");
            }
            entity.setAddress(vendor.getAddress());
            entity.setDob(vendor.getDob());
            entity.setEmail(vendor.getEmail());
            entity.setMobile(vendor.getMobile());
            entity.setName(vendor.getName());
            entity.setGstNo(vendor.getGstNo());
            return vendorRepo.save(entity);
        
        } catch (Exception e) {
            e.printStackTrace();
            return entity;
        }
    }

    @Override
    public boolean deleteVendor(long id) {
        try {
            vendorRepo.deleteById(id);
            return true;
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
    }
    
}
