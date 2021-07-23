package com.coma.Repository;

import java.util.List;

import com.coma.Entity.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceRepo extends JpaRepository<Invoice,Long>
{
    @Query(value ="SELECT p.invoice_no from invoice_t p",nativeQuery = true)
    List<Long> findAllInvoiceNo();
}
