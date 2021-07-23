package com.coma.Billing.Process.service;

import com.coma.Billing.Process.model.GeneratedInvoiceRes;
import com.coma.Billing.Process.model.InvoiceGetRes;

import java.util.List;

import com.coma.Billing.Process.model.GenerateInvoiceReq;



public interface SalesService 
{
   GeneratedInvoiceRes generateInvoice(GenerateInvoiceReq request);   
   InvoiceGetRes getInvoiceDetail(long invoiceNo);
   List<InvoiceGetRes> getAllInvoiceDetail(); 
     
}
