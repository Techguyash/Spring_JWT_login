package com.coma.Billing.Process.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.coma.Billing.Data.service.CustomerService;
import com.coma.Billing.Data.service.DiscountService;
import com.coma.Billing.Data.service.ProductService;
import com.coma.Billing.Data.service.TaxService;
import com.coma.Billing.Process.model.GenerateInvoiceReq;
import com.coma.Billing.Process.model.GeneratedInvoiceRes;
import com.coma.Billing.Process.model.InvoiceGetRes;
import com.coma.Billing.Process.model.InvoiceProducts;
import com.coma.Entity.AppUser;
import com.coma.Entity.Customer;
import com.coma.Entity.Discount;
import com.coma.Entity.Invoice;
import com.coma.Entity.Products;
import com.coma.Entity.SalesOrder;
import com.coma.Entity.Tax;
import com.coma.Repository.InvoiceRepo;
import com.coma.Repository.SalesOrderRepo;
import com.coma.Repository.UserRepo;

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

  @Autowired
  DiscountService discountService;

  @Autowired
  TaxService taxService;

  @Override
  public GeneratedInvoiceRes generateInvoice(GenerateInvoiceReq request) 
  {
    try {
      AppUser biller = null;
      Customer customer = null;
      // check biller is valid
      biller = billerRepo.findById((request.getBillerId())).get();
      if (biller == null) {
        throw new IllegalStateException("biller not valid");
      }

      // customer is valid
      customer = customerService.getCustomer(request.getCustomerId());
      if (customer == null) {
        throw new IllegalStateException("customer is not valid");
      }
      // discount logic
      float amountTobepaid = 0;
      float discountValue = 0;
      float taxValue = 0;
      float billedAmount = request.getBilledAmount();

      Discount discount = discountService.getDiscount(request.getDiscount());
      Tax tax = taxService.getTax(request.getTax());

      /**
       * if the discount value is Zero i.e no discount fetching default no discount
       * value from db with discount Id=0 if the tax value is zero i.e no tax is
       * applied fetchig the default no tax value from db with tax Id=0
       */
      if (discount == null || discount.getPercentageVal() <= 0 || discount.isEnabled() == false) {
        discount = discountService.getDiscount(0);
      }
      if (tax == null || tax.getPercentage() <= 0 || tax.isEnabled() == false) {
        tax = taxService.getTax(0);
      }

      if (discount != null && discount.getPercentageVal() > 0) {
        discountValue = (discount.getPercentageVal() / 100.f) * billedAmount;
        amountTobepaid = billedAmount - discountValue;
      }
      else {
        amountTobepaid = billedAmount;
      }
      // tax logic
      if (tax != null && tax.getPercentage() > 0) {
        taxValue = (tax.getPercentage() / 100.f) * amountTobepaid;
        amountTobepaid += taxValue;
      } 

      Invoice invoiceEntity = new Invoice();
      invoiceEntity.setAmountPaid(amountTobepaid);
      invoiceEntity.setBilledAmount(request.getBilledAmount());
      LocalDateTime billedAt = LocalDateTime.now();
      invoiceEntity.setBilledAt(billedAt);
      invoiceEntity.setBiller(biller);
      invoiceEntity.setCustomer(customer);
      invoiceEntity.setDiscount(discount);
      invoiceEntity.setTax(tax);
      invoiceEntity.setPaymentType(request.getPaymentType());
      System.out.println(invoiceEntity.getDiscount().toString());
      Invoice invoice = invoiceRepo.save(invoiceEntity);
      System.out.println("invoice generated\n");

      SalesOrder salesOrder = null;
      List<InvoiceProducts> productsList = request.getProductsList();
      // saving data of individual product
      for (InvoiceProducts productReceived : productsList) {
        salesOrder = new SalesOrder();
        Products soldProduct = productService.getProduct(productReceived.getProductId());
        salesOrder.setProduct(soldProduct);
        salesOrder.setInvoice(invoice);
        salesOrder.setQty(productReceived.getQty());
        salesOrder.setSoldPrice(productReceived.getPrice());
        salesOrder.setTotal(productReceived.getTotal());
        salesOrderRepo.save(salesOrder);
        System.out.println("\n Sales orders created");
      }

      GeneratedInvoiceRes response = new GeneratedInvoiceRes();
      response.setAmountPaid(amountTobepaid);
      response.setBilledAt(billedAt);
      response.setBillerName(biller.getName());
      response.setInvoiceNo(invoice.getInvoiceNo());
      response.setTaxName(tax.getTaxName());
      response.setTax(tax.getPercentage());
      response.setDiscount(discount.getPercentageVal());

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

      InvoiceGetRes response = new InvoiceGetRes();
      Invoice invoiceData = invoiceRepo.findById(invoiceNo).get();
      if (invoiceData == null) {
        throw new IllegalStateException("invalid invoice number");
      }

      response.setInvoiceNo(invoiceNo);
      response.setBillerName(invoiceData.getBiller().getName());
      response.setBilledAt(invoiceData.getBilledAt());
      response.setAmountPaid(invoiceData.getAmountPaid());
      response.setBilledAmount(invoiceData.getBilledAmount());
      response.setDiscount(invoiceData.getDiscount().getPercentageVal());
      response.setPaymentType(invoiceData.getPaymentType());
      response.setCustomerName(invoiceData.getCustomer().getName());
      // fetch individual products
      List<InvoiceProducts> productList = new ArrayList<InvoiceProducts>();
      List<SalesOrder> soldProductsList = salesOrderRepo.findAllByInvoiceNo(invoiceNo);
      if (soldProductsList.isEmpty()) {
        throw new IllegalStateException("No products found");
      }
      for (SalesOrder order : soldProductsList) {
        InvoiceProducts products = new InvoiceProducts();
        products.setPrice(order.getSoldPrice());
        products.setProductId(order.getProduct().getProductId());
        products.setProductName(order.getProduct().getProductName());
        products.setQty(order.getQty());
        products.setTotal(order.getTotal());
        productList.add(products);
      }
      //fetch discount details
      Discount availDiscount = invoiceData.getDiscount();
      response.setDiscount(availDiscount.getPercentageVal());
       //fetch tax details
       Tax availTax = invoiceData.getTax();
      response.setTax(availTax.getPercentage());
      response.setTaxName(availTax.getTaxName());

      response.setProducts(productList);

      return response;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  @Override
  public List<InvoiceGetRes> getAllInvoiceDetail() 
  {

    List<InvoiceGetRes> invoices = null;
    try {
      List<Long> allInvoiceNo = invoiceRepo.findAllInvoiceNo();
      if (allInvoiceNo.isEmpty()) {
        throw new IllegalStateException("No invoices found");
      }
      invoices = new ArrayList<InvoiceGetRes>();
      for (long inv : allInvoiceNo) {
        InvoiceGetRes invoiceDetail = getInvoiceDetail(inv);
        invoices.add(invoiceDetail);
      }
      return invoices;

    } catch (Exception e) {
      return invoices;
    }

  }

  

}
