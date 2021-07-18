package com.coma.controller;

import com.coma.Billing.Data.model.CreateCategoryRequest;
import com.coma.Billing.Data.model.CreateProductRequest;
import com.coma.Billing.Data.service.CategoryService;
import com.coma.Billing.Data.service.ProductService;
import com.coma.Billing.Data.service.UnitService;
import com.coma.Entity.Category;
import com.coma.Entity.Products;
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

  //TODO: controller mapping for Units

  @PostMapping("/units")
  public ResponseEntity<Units> createUnit(@RequestBody Units unit)
    throws Exception {
    try {
      Units createUnit = null;
      createUnit = unitService.createUnit(unit);
      if (createUnit == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Units>(createUnit, HttpStatus.OK);
    } catch (Exception e) {
      throw new Exception("error, Please check log");
    }
  }

  @DeleteMapping("/units/{unitId}")
  public ResponseEntity<Object> removeUnit(@PathVariable int unitId) {
    try {
      unitService.deleleUnit(unitId);
      return new ResponseEntity<Object>("success", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
    }
  }

  @GetMapping("/units")
  public List<Units> getAllUnits() throws Exception {
    try {
      return unitService.getAllUnits();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @GetMapping("/units/{unitId}")
  public Units getUnit(@PathVariable int unitId) throws Exception {
    try {
       Units unit = unitService.getUnit(unitId);
       if(unit==null)
       {
        throw new Exception("Value not found");
       }
      
       return unit;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  //TODO: controller mapping for Products

  @PostMapping("/product")
  public ResponseEntity<Products> createProduct(
    @RequestBody CreateProductRequest req
  )
    throws Exception {
    try {
      Products product = productService.createProduct(req);
      if (product == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Products>(product, HttpStatus.OK);
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
      throw new Exception("Error, Please check log");
    }
  }

  @DeleteMapping("/product/{productId}")
  public ResponseEntity<Object> removeProduct(@PathVariable int Id) {
    try {
      productService.deleteProduct(Id);
      return new ResponseEntity<Object>("success", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/products")
  public List<Products> getAllProducts() throws Exception {
    try {
      return productService.getAllProducts();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @GetMapping("/products/{id}")
  public Products getProducts(@PathVariable long id) throws Exception {
    try {
      return productService.getProduct(id);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @PutMapping("/product")
  public ResponseEntity<Products> updateProduct(@RequestBody Products req)
    throws Exception {
    try {
      Products product = productService.updateProduct(req);
      if (product == null) {
        throw new Exception("Failed to update, Please check log");
      }
      return new ResponseEntity<Products>(product, HttpStatus.OK);
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
      throw new Exception("Error, Please check log");
    }
  }

  //TODO: controller mapping for Category

  @PostMapping("/category")
  public ResponseEntity<Category> createCategory(
    @RequestBody CreateCategoryRequest req
  )
    throws Exception {
    try {
      Category createCategory = null;
      createCategory = categoryService.createCategory(req);
      if (createCategory == null) {
        throw new Exception("Failed to create, Please check log");
      }
      return new ResponseEntity<Category>(createCategory, HttpStatus.OK);
    } catch (Exception e) {
      throw new Exception("error, Please check log");
    }
  }

  @DeleteMapping("category/{id}")
  public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
    try {
      if (categoryService.deleteCategory(id)) {
        return new ResponseEntity<Object>("success", HttpStatus.OK);
      }
      return new ResponseEntity<Object>("error", HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/category")
  public List<Category> getAllCategory() throws Exception {
    try {
      return categoryService.getAllCategorys();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @GetMapping("/category/{categoryId}")
  public Category getCategory(@PathVariable int categoryId) throws Exception {
    try {
      return categoryService.getCategory(categoryId);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }



@PutMapping("/category")
  public ResponseEntity<Category> updateCategory(@RequestBody Category req)
    throws Exception {
    try {
      Category category = categoryService.updateCategory(req);
      if (category == null) {
        throw new Exception("Failed to update, Please check log");
      }
      return new ResponseEntity<Category>(category, HttpStatus.OK);
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
      throw new Exception("Error, Please check log");
    }
  }

}
