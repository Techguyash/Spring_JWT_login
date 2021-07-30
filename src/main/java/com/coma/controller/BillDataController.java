package com.coma.controller;

import com.coma.Billing.Data.model.CreateCategoryRequest;
import com.coma.Billing.Data.model.CreateProductRequest;
import com.coma.Billing.Data.service.CategoryService;
import com.coma.Billing.Data.service.CustomerService;
import com.coma.Billing.Data.service.ProductService;
import com.coma.Billing.Data.service.UnitService;
import com.coma.Billing.Data.service.VendorService;
import com.coma.Entity.Category;
import com.coma.Entity.Customer;
import com.coma.Entity.Products;
import com.coma.Entity.Units;
import com.coma.Entity.Vendor;
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
  VendorService vendorService;

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

  //TODO: controller mapping for Vendor

  @PostMapping("/vendor")
  public ResponseEntity<Vendor> createVendor(@RequestBody Vendor req)
    throws Exception {
   
      Vendor createVendor = null;
      createVendor = vendorService.createVendor(req);
      if (createVendor == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Vendor>(createVendor, HttpStatus.OK);
  
  }

  @DeleteMapping("vendor/{id}")
  public ResponseEntity<Object> deleteVendor(@PathVariable int id) {
   
      if (vendorService.deleteVendor(id)) {
        return new ResponseEntity<Object>("success", HttpStatus.OK);
      }
      return new ResponseEntity<Object>("error", HttpStatus.BAD_REQUEST);
  
  }

  @GetMapping("/vendor")
  public List<Vendor> getAllVendor() throws Exception {
   
      return vendorService.getAllVendors();
  
  }

  @GetMapping("/vendor/{vendorId}")
  public Vendor getVendor(@PathVariable int vendorId) throws Exception {
   
      return vendorService.getVendor(vendorId);
   
  }

  @PutMapping("/vendor")
  public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor req)
    throws Exception {
  
      Vendor vendor = vendorService.updateVendor(req);
      if (vendor == null) {
        throw new Exception("Failed to update, Please check log");
      }
      return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
  
  }
}
