package com.coma.Repository;

import com.coma.Entity.Tax;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepo extends JpaRepository<Tax,Integer>{
    
}
