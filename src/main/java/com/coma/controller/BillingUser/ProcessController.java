package com.coma.controller.BillingUser;

import com.coma.Billing.Process.model.GeneratedInvoiceRes;
import com.coma.Billing.Process.model.InvoiceGetRes;

import java.util.List;

import com.coma.Billing.Data.service.CategoryService;
import com.coma.Billing.Data.service.CustomerService;
import com.coma.Billing.Data.service.ProductService;
import com.coma.Billing.Data.service.UnitService;
import com.coma.Billing.Process.model.GenerateInvoiceReq;
import com.coma.Billing.Process.service.SalesService;
import com.coma.Entity.Category;
import com.coma.Entity.Customer;
import com.coma.Entity.Products;
import com.coma.Entity.Units;

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
@RequestMapping("/api/v1/billProcess")
public class ProcessController {
    
    @Autowired
    SalesService salesService;

    @Autowired
    UnitService unitService;
  
    @Autowired
    ProductService productService;
  
    @Autowired
    CategoryService categoryService;
  
    @Autowired
    CustomerService customerService;
  
  
   

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

    @GetMapping("/units")
    public List<Units> getAllUnits() throws Exception {
        return unitService.getAllUnits();
    
    }

    @GetMapping("/product")
    public List<Products> getAllProducts() throws Exception {
  
        return productService.getAllProducts();
     
    }

    @GetMapping("/category")
    public List<Category> getAllCategory() throws Exception {
    
        return categoryService.getAllCategorys();
     
    }
  

  @GetMapping("/customer")
  public List<Customer> getAllCustomer() throws Exception {
   
      return customerService.getAllCustomers();
  
  }
    
}
