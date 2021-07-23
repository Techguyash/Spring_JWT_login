package com.coma.Billing.Process.service;

import com.coma.Billing.Data.service.CustomerService;
import com.coma.Billing.Data.service.ProductService;
import com.coma.Billing.Process.model.GeneratedInvoiceRes;
import com.coma.Billing.Process.model.InvoiceGetRes;
import com.coma.Billing.Process.model.InvoiceProducts;
import com.coma.Billing.Process.model.GenerateInvoiceReq;
import com.coma.Entity.AppUser;
import com.coma.Entity.Customer;
import com.coma.Entity.Invoice;
import com.coma.Entity.Products;
import com.coma.Entity.SalesOrder;
import com.coma.Repository.InvoiceRepo;
import com.coma.Repository.SalesOrderRepo;
import com.coma.Repository.UserRepo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService_Impl implements SalesService {

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
  public GeneratedInvoiceRes generateInvoice(GenerateInvoiceReq request) {
    try {
      AppUser biller = null;
      Customer customer = null;
      //check biller is valid
      biller = billerRepo.findById((request.getBillerId())).get();
      if (biller == null) {
        throw new IllegalStateException("biller not valid");
      }

      //customer is valid
      customer = customerService.getCustomer(request.getCustomerId());
      if (customer == null) {
        throw new IllegalStateException("customer is not valid");
      }

      float paidAmount = request.getBilledAmount() - request.getDiscount();
      Invoice invoiceEntity = new Invoice();
      invoiceEntity.setAmountPaid(paidAmount);
      invoiceEntity.setBilledAmount(request.getBilledAmount());
      LocalDateTime billedAt = LocalDateTime.now();
      invoiceEntity.setBilledAt(billedAt);
      invoiceEntity.setBiller(biller);
      invoiceEntity.setCustomer(customer);
      invoiceEntity.setDiscount(request.getDiscount());
      invoiceEntity.setPaymentType(request.getPaymentType());
      Invoice invoice = invoiceRepo.save(invoiceEntity);
      System.out.println("invoice generated\n");
      SalesOrder salesOrder = null;
      List<InvoiceProducts> productsList = request.getProductsList();
      //saving data of individual product
      for (InvoiceProducts productReceived : productsList) {
        salesOrder = new SalesOrder();
        Products soldProduct = productService.getProduct(
          productReceived.getProductId()
        );
        salesOrder.setProduct(soldProduct);
        salesOrder.setInvoice(invoice);
        salesOrder.setQty(productReceived.getQty());
        salesOrder.setSoldPrice(productReceived.getPrice());
        salesOrder.setTotal(productReceived.getTotal());
        salesOrderRepo.save(salesOrder);
      }

      GeneratedInvoiceRes response = new GeneratedInvoiceRes();
      response.setAmountPaid(paidAmount);
      response.setBilledAt(billedAt);
      response.setBillerName(biller.getFirstName());
      response.setInvoiceNo(invoice.getInvoiceNo());

      return response;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public InvoiceGetRes getInvoiceDetail(long invoiceNo)
  {

    try {
        
      InvoiceGetRes response=new InvoiceGetRes();
      Invoice invoiceData = invoiceRepo.findById(invoiceNo).get();
    if(invoiceData==null)
    {
      throw new IllegalStateException("invalid invoice number"); 
    }

    response.setInvoiceNo(invoiceNo);
    response.setBillerName(invoiceData.getBiller().getFirstName());
    response.setBilledAt(invoiceData.getBilledAt());
    response.setAmountPaid(invoiceData.getAmountPaid());
    response.setBilledAmount(invoiceData.getBilledAmount());
    response.setDiscount(invoiceData.getDiscount());
    response.setPaymentType(invoiceData.getPaymentType());
    response.setCustomerName(invoiceData.getCustomer().getName());
    //fetch individual products
    List<InvoiceProducts> productList= new ArrayList<InvoiceProducts>();
    List<SalesOrder> soldProductsList = salesOrderRepo.findAllByInvoiceNo(invoiceNo);
    if(soldProductsList.isEmpty())
    {
      throw new IllegalStateException("No products found");
    }
    for(SalesOrder order : soldProductsList)
    {
      InvoiceProducts products=new InvoiceProducts();
      products.setPrice(order.getSoldPrice());
      products.setProductId(order.getProduct().getProductId());
      products.setProductName(order.getProduct().getProductName());
      products.setQty(order.getQty());
      products.setTotal(order.getTotal());
      productList.add(products);
    }

    response.setProducts(productList);

    return response;


    } catch (Exception e) {
       e.printStackTrace();
       return null;
    }
  
  }

  @Override
  public List<InvoiceGetRes> getAllInvoiceDetail() {
   
    List<InvoiceGetRes> invoices=null;
    try {
      List<Long> allInvoiceNo = invoiceRepo.findAllInvoiceNo();
      if(allInvoiceNo.isEmpty())
      {
        throw new IllegalStateException("No invoices found"); 
      }
      invoices=new ArrayList<InvoiceGetRes>();
      for(long inv : allInvoiceNo)
      {
        InvoiceGetRes invoiceDetail = getInvoiceDetail(inv);
        invoices.add(invoiceDetail);
      }
      return invoices;
   
   } catch (Exception e) {
    return invoices;
   }
   
  }

}
