package com.coma.Repository;

import com.coma.Entity.SalesOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepo extends JpaRepository<SalesOrder,Long>{
    
}
