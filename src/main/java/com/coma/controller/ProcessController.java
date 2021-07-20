package com.coma.controller;

import java.util.ArrayList;
import java.util.List;

import com.coma.Billing.Process.model.InvoiceGeneratedRes;
import com.coma.Billing.Process.model.InvoiceProductListReq;
import com.coma.Billing.Process.model.InvoiceRequest;
import com.coma.Billing.Process.service.SalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    InvoiceGeneratedRes generateBill(@RequestBody InvoiceRequest request)
    {
        InvoiceGeneratedRes generateInvoice = salesService.generateInvoice(request);

        return generateInvoice;
    }

    @GetMapping("/")
    InvoiceRequest getList()
    {
        InvoiceRequest data = new InvoiceRequest();
        List<InvoiceProductListReq> productsList = new ArrayList<>();
        
        InvoiceProductListReq list1= new InvoiceProductListReq();
        list1.setPrice(100);
        list1.setProductId(1);
        list1.setQty(1);
        list1.setTotal(100);
        InvoiceProductListReq list2= new InvoiceProductListReq();
        list2.setPrice(200);
        list2.setProductId(2);
        list2.setQty(2);
        list2.setTotal(400);
       
       
        
        productsList.add(list1);
        productsList.add(list2);

        data.setBilledAmount(100);
        data.setBillerId(1);
        data.setCustomerId(1);
        data.setDiscount(100);
        data.setPaymentType("cash");
        data.setProductsList(productsList);
        return data;
    }
    
}
