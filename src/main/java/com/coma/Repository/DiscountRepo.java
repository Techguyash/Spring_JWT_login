package com.coma.Repository;

import com.coma.Entity.Discount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepo extends JpaRepository<Discount,Integer>{
    
}
