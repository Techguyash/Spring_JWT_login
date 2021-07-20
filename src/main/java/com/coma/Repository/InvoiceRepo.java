package com.coma.Repository;

import com.coma.Entity.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice,Long>
{
    
}
