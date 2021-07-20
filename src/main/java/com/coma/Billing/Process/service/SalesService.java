package com.coma.Billing.Process.service;

import com.coma.Billing.Process.model.InvoiceGeneratedRes;
import com.coma.Billing.Process.model.InvoiceRequest;


public interface SalesService 
{
   InvoiceGeneratedRes generateInvoice(InvoiceRequest request);    
     
}
