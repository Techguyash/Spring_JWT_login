package com.coma.Billing.Process.service;

import java.time.LocalDateTime;
import java.util.List;

import com.coma.Billing.Data.service.CustomerService;
import com.coma.Billing.Data.service.ProductService;
import com.coma.Billing.Process.model.InvoiceGeneratedRes;
import com.coma.Billing.Process.model.InvoiceProductListReq;
import com.coma.Billing.Process.model.InvoiceRequest;
import com.coma.Entity.AppUser;
import com.coma.Entity.Customer;
import com.coma.Entity.Invoice;
import com.coma.Entity.Products;
import com.coma.Entity.SalesOrder;
import com.coma.Repository.InvoiceRepo;
import com.coma.Repository.SalesOrderRepo;
import com.coma.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService_Impl implements SalesService
{
    @Autowired
   CustomerService customerService;

    @Autowired
    UserRepo billerRepo;

    @Autowired
   ProductService productService;

    @Autowired
    InvoiceRepo invoiceRepo;

    @Autowired
    SalesOrderRepo salesOrderRepo;

    @Override
    public InvoiceGeneratedRes generateInvoice(InvoiceRequest request) {

        try 
        {
            AppUser biller=null;
            Customer customer =null;
            //check biller is valid
            biller= billerRepo.findById((request.getBillerId())).get();
            if(biller==null)
            {
                throw new IllegalStateException("biller not valid");
            }

            //customer is valid
             customer = customerService.getCustomer(request.getCustomerId());
             if(customer==null)
             {
                 throw new IllegalStateException("customer is not valid");
             }

            float paidAmount=request.getBilledAmount()-request.getDiscount();
            Invoice invoiceEntity=new Invoice();
            invoiceEntity.setAmountPaid(paidAmount);
            invoiceEntity.setBilledAmount(request.getBilledAmount());
            LocalDateTime billedAt=LocalDateTime.now();
            invoiceEntity.setBilledAt(billedAt);
            invoiceEntity.setBiller(biller);
            invoiceEntity.setCustomer(customer);
            invoiceEntity.setDiscount(request.getDiscount());
            invoiceEntity.setPaymentType(request.getPaymentType());
            Invoice invoice = invoiceRepo.save(invoiceEntity);
            System.out.println("invoice generated\n");
            System.out.println(invoice.toString());
            SalesOrder salesOrder=null;
            List<InvoiceProductListReq> productsList = request.getProductsList();
            //saving data of individual product
            for(InvoiceProductListReq productReceived : productsList)
            {
                salesOrder=new SalesOrder();
                Products soldProduct = productService.getProduct(productReceived.getProductId());
                salesOrder.setProduct(soldProduct);
                salesOrder.setInvoice(invoice);
                salesOrder.setQty(productReceived.getQty());
                salesOrder.setSoldPrice(productReceived.getPrice());
                salesOrder.setTotal(productReceived.getTotal());
                salesOrderRepo.save(salesOrder);
            }

            InvoiceGeneratedRes response=new InvoiceGeneratedRes();
            response.setAmountPaid(paidAmount);
            response.setBilledAt(billedAt);
            response.setBillerName(biller.getFirstName());
            response.setInvoiceNo(invoice.getInvoiceNo());
            
            return response;
        }
      
         catch (Exception e) 
         {
            
            e.printStackTrace();
            return null;
        }
      


        //return null;
    }

  

    
}
