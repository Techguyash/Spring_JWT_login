package com.coma.Repository;

import com.coma.Entity.Vendor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor,Long> {
    
}
