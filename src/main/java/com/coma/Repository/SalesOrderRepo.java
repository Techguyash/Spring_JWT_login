package com.coma.Repository;

import java.util.List;

import com.coma.Entity.SalesOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SalesOrderRepo extends JpaRepository<SalesOrder,Long>{
    
    @Query("select p from SalesOrder p where invoice_no=?1")
    List<SalesOrder> findAllByInvoiceNo(long invoiceNo);
  

    
}
