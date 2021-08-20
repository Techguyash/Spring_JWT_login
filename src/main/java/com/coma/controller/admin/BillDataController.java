package com.coma.controller.admin;

import com.coma.Billing.Data.model.CreateCategoryRequest;
import com.coma.Billing.Data.model.CreateDiscountRequest;
import com.coma.Billing.Data.model.CreateProductRequest;
import com.coma.Billing.Data.model.CreateTaxRequest;
import com.coma.Billing.Data.service.CategoryService;
import com.coma.Billing.Data.service.CustomerService;
import com.coma.Billing.Data.service.DiscountService;
import com.coma.Billing.Data.service.ProductService;
import com.coma.Billing.Data.service.TaxService;
import com.coma.Billing.Data.service.UnitService;
import com.coma.Billing.Process.model.GenerateInvoiceReq;
import com.coma.Billing.Process.model.GeneratedInvoiceRes;
import com.coma.Billing.Process.model.InvoiceGetRes;
import com.coma.Billing.Process.service.SalesService;
import com.coma.Entity.Category;
import com.coma.Entity.Customer;
import com.coma.Entity.Discount;
import com.coma.Entity.Products;
import com.coma.Entity.Tax;
import com.coma.Entity.Units;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
public class BillDataController {

  @Autowired
  UnitService unitService;

  @Autowired
  ProductService productService;

  @Autowired
  CategoryService categoryService;

  @Autowired
  CustomerService customerService;

 

  @Autowired
  SalesService salesService;

  @Autowired
  TaxService taxService;

  @Autowired
  DiscountService discountService;

  //TODO: controller mapping for Units

  @PostMapping("/units")
  public ResponseEntity<Units> createUnit(@RequestBody Units unit)
    throws Exception {
    
      Units createUnit = null;
      createUnit = unitService.createUnit(unit);
      if (createUnit == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Units>(createUnit, HttpStatus.OK);
  
  }

  @DeleteMapping("/units/{unitId}")
  public ResponseEntity<Object> removeUnit(@PathVariable int unitId) {
  
      unitService.deleleUnit(unitId);
      return new ResponseEntity<Object>("success", HttpStatus.OK);
  
  }

  @GetMapping("/units")
  public List<Units> getAllUnits() throws Exception {
  
      return unitService.getAllUnits();
  
  }

  @GetMapping("/units/{unitId}")
  public Units getUnit(@PathVariable int unitId) throws Exception {
   
      Units unit = unitService.getUnit(unitId);
      if (unit == null) {
        throw new Exception("Value not found");
      }

      return unit;
  
  }

  //TODO: controller mapping for Products

  @PostMapping("/product")
  public ResponseEntity<Products> createProduct(
    @RequestBody CreateProductRequest req
  )
    throws Exception {
  
      Products product = productService.createProduct(req);
      if (product == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Products>(product, HttpStatus.OK);
  
  }

  @DeleteMapping("/product/{Id}")
  public ResponseEntity<Object> removeProduct(@PathVariable int Id) {
  
      productService.deleteProduct(Id);
      return new ResponseEntity<Object>("success", HttpStatus.OK);

  }

  @GetMapping("/product")
  public List<Products> getAllProducts() throws Exception {

      return productService.getAllProducts();
   
  }

  @GetMapping("/product/{id}")
  public Products getProducts(@PathVariable long id) throws Exception {
  
      return productService.getProduct(id);
 
  }

  @PutMapping("/product")
  public ResponseEntity<Products> updateProduct(@RequestBody Products req)
    throws Exception {
   
      Products product = productService.updateProduct(req);
      if (product == null) {
        throw new Exception("Failed to update, Please check log");
      }
      return new ResponseEntity<Products>(product, HttpStatus.OK);
 
  }

  //TODO: controller mapping for Category

  @PostMapping("/category")
  public ResponseEntity<Category> createCategory(
    @RequestBody CreateCategoryRequest req
  )
    throws Exception {
   
      Category createCategory = null;
      createCategory = categoryService.createCategory(req);
      if (createCategory == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Category>(createCategory, HttpStatus.OK);
    
  }

  @DeleteMapping("category/{id}")
  public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
  
      if (categoryService.deleteCategory(id)) {
        return new ResponseEntity<Object>("success", HttpStatus.OK);
      }
      return new ResponseEntity<Object>("error", HttpStatus.BAD_REQUEST);
  
  }

  @GetMapping("/category")
  public List<Category> getAllCategory() throws Exception {
  
      return categoryService.getAllCategorys();
   
  }

  @GetMapping("/category/{categoryId}")
  public Category getCategory(@PathVariable int categoryId) throws Exception {
  
      return categoryService.getCategory(categoryId);
  
  }

  @PutMapping("/category")
  public ResponseEntity<Category> updateCategory(@RequestBody Category req)
    throws Exception {
   
      Category category = categoryService.updateCategory(req);
      if (category == null) {
        throw new Exception("Failed to update, Please check log");
      }
      return new ResponseEntity<Category>(category, HttpStatus.OK);
  
  }

  //TODO: controller mapping for Customer

  @PostMapping("/customer")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer req)
    throws Exception {
 
      Customer createCustomer = null;
      createCustomer = customerService.createCustomer(req);
      if (createCustomer == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Customer>(createCustomer, HttpStatus.OK);
   
  }

  @DeleteMapping("customer/{id}")
  public ResponseEntity<Object> deleteCustomer(@PathVariable int id) {
   
      if (customerService.deleteCustomer(id)) {
        return new ResponseEntity<Object>("success", HttpStatus.OK);
      }
      return new ResponseEntity<Object>("error", HttpStatus.BAD_REQUEST);
 
  }

  @GetMapping("/customer")
  public List<Customer> getAllCustomer() throws Exception {
   
      return customerService.getAllCustomers();
  
  }

  @GetMapping("/customer/{customerId}")
  public Customer getCustomer(@PathVariable int customerId) throws Exception {
   
      return customerService.getCustomer(customerId);
  
  }

  @PutMapping("/customer")
  public ResponseEntity<Customer> updateCustomer(@RequestBody Customer req)
    throws Exception {
  
      Customer customer = customerService.updateCustomer(req);
      if (customer == null) {
        throw new Exception("Failed to update, Please check log");
      }
      return new ResponseEntity<Customer>(customer, HttpStatus.OK);
   
  }

 
  //TODO: Invoice Endpoints
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
  
  //TODO: Tax controller

  @PostMapping("/tax")
  public ResponseEntity<Tax> createTax(@RequestBody CreateTaxRequest req)
    throws Exception {
   
      Tax tax = null;
      tax = taxService.createTax(req);
      if (tax == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Tax>(tax, HttpStatus.OK);
  
  }


  @DeleteMapping("tax/{id}")
  public ResponseEntity<Object> deleteTax(@PathVariable int id) {
   
      if (taxService.deleteTax(id)) {
        return new ResponseEntity<Object>("success", HttpStatus.OK);
      }
      return new ResponseEntity<Object>("error", HttpStatus.BAD_REQUEST);
  
  }

  @GetMapping("/tax")
  public List<Tax> getAllTax() throws Exception {
   
      return taxService.getAllTax();
  
  }

  @GetMapping("/tax/{taxId}")
  public Tax getTax(@PathVariable int taxId) throws Exception {
   
      return taxService.getTax(taxId);
  }


  @PutMapping("/tax")
  public ResponseEntity<Tax> updateTax(@RequestBody Tax req)
    throws Exception {
  
      Tax tax =null;
      tax= taxService.updateTax(req);
      if (tax == null) {
        throw new Exception("Failed to update, Please check log");
      }
      return new ResponseEntity<Tax>(tax, HttpStatus.OK);
  
  }



//TODO:Discount controller mapping

@PostMapping("/discount")
public ResponseEntity<Discount> createDiscount(@RequestBody CreateDiscountRequest req)
  throws Exception {
 
    Discount discount = null;
    discount = discountService.createDiscount(req);
    if (discount == null) {
      throw new Exception("Failed to create, Please check log");
    }
    return new ResponseEntity<Discount>(discount, HttpStatus.OK);

}


@DeleteMapping("discount/{id}")
public ResponseEntity<Object> deleteDiscount(@PathVariable int id) {
 
    if (discountService.deleteDiscount(id)) {
      return new ResponseEntity<Object>("success", HttpStatus.OK);
    }
    return new ResponseEntity<Object>("error", HttpStatus.BAD_REQUEST);

}

@GetMapping("/discount")
public List<Discount> getAllDiscount() throws Exception {
 
    return discountService.getAllDiscounts();

}

@GetMapping("/discount/{discountId}")
public Discount getDiscount(@PathVariable int discountId) throws Exception {
 
    return discountService.getDiscount(discountId);
}


@PutMapping("/discount")
public ResponseEntity<Discount> updateDiscount(@RequestBody Discount req)
  throws Exception {

    Discount discount =null;
    discount= discountService.updateDiscount(req);
    if (discount == null) {
      throw new Exception("Failed to update, Please check log");
    }
    return new ResponseEntity<Discount>(discount, HttpStatus.OK);

}


}
