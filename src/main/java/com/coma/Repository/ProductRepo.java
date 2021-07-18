package com.coma.Repository;

import com.coma.Entity.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products,Long>{
    
}
