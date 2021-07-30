package com.coma.controller;

import com.coma.Billing.Process.model.GeneratedInvoiceRes;
import com.coma.Billing.Process.model.InvoiceGetRes;

import java.util.List;

import com.coma.Billing.Process.model.GenerateInvoiceReq;
import com.coma.Billing.Process.service.SalesService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/process")
public class ProcessController {
    
    @Autowired
    SalesService salesService;
   

    @PostMapping("/generateInvoice")
  
    GeneratedInvoiceRes generateBill(@RequestBody GenerateInvoiceReq request)
    {
        GeneratedInvoiceRes generateInvoice = salesService.generateInvoice(request);
        return generateInvoice;
    }

    @GetMapping("/invoice/{invoiceNo}")
    ResponseEntity<InvoiceGetRes> fetchBill(@PathVariable long invoiceNo) throws Exception
    {
      InvoiceGetRes invoiceDetail=null;
   
        invoiceDetail= salesService.getInvoiceDetail(invoiceNo);
        if(invoiceDetail==null)
        {
          throw new Exception("No invoice found");
        }
          return new ResponseEntity<InvoiceGetRes>(invoiceDetail,HttpStatus.OK);
          
    

      
    }

    @GetMapping("/invoice")
    ResponseEntity<List<InvoiceGetRes>> fetchAllBill() throws Exception
    {
       List<InvoiceGetRes> allInvoiceDetail=null;
    
         allInvoiceDetail = salesService.getAllInvoiceDetail();
        if(allInvoiceDetail==null || allInvoiceDetail.isEmpty())
        {
          throw new Exception("No invoice found");
        }
          return new ResponseEntity<List<InvoiceGetRes>>(allInvoiceDetail,HttpStatus.OK);
          
    

      
    }
    
}
