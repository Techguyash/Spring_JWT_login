package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Entity.Vendor;

public interface VendorService  {


    Vendor createVendor(Vendor category);
    Vendor getVendor(long id);
   List<Vendor> getAllVendors();
   Vendor updateVendor(Vendor category);
   boolean deleteVendor(long Id);
    
}
