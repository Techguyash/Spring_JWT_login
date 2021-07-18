package com.coma.Billing.Data.service;

import com.coma.Billing.Data.model.CreateProductRequest;
import com.coma.Entity.Category;
import com.coma.Entity.Products;
import com.coma.Entity.Units;
import com.coma.Repository.ProductRepo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService_impl implements ProductService {

  @Autowired
  ProductRepo repo;

  @Autowired
  UnitService unitService;

  @Autowired
  CategoryService categoryService;

  @Override
  public Products createProduct(CreateProductRequest product) {
    Units unit = null;
    try {
      //TODO : extract unit as a string from req and assign in unit obj

      unit = unitService.getUnit(product.getUnitId());
      if (unit == null) {
        throw new Exception("Invalid unit");
      }
      //TODO : extract category as a string from req and assign in category obj

      Category category = categoryService.getCategory(product.getCategoryId());
      if (category == null) {
        throw new Exception("Invalid category");
      }

      Products entity = new Products();
      entity.setProductName(product.getProductName());
      entity.setStockQty(product.getStockQty());
      entity.setUnit(unit);
      entity.setPrice(product.getPrice());
      entity.setDescription(product.getDescription());
      entity.setCreatedOn(LocalDate.now());
      entity.setCategory(category);
      return repo.save(entity);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Products> getAllProducts() {
    try {
      return repo.findAll();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Products getProduct(long id) {
    try {
      return repo.getById(id);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Products updateProduct(Products product) {
    Units unit = null;
    Products availData = null;
    try {
         availData = getProduct(product.getProductId());
      //TODO : extract unit as a string from req and assign in unit obj

      unit = unitService.getUnit(product.getUnit().getUnitId());
      if (unit == null) {
        throw new Exception("Invalid unit");
      }
      //TODO : extract category as a string from req and assign in category obj

      Category category = categoryService.getCategory(product.getCategory().getCategoryId());
      if (category == null) {
        throw new Exception("Invalid category");
      } 
            
            availData.setCategory(product.getCategory());
            availData.setUnit(product.getUnit());
            availData.setDescription(product.getDescription());
            availData.setPrice(product.getPrice());
            availData.setProductName(product.getProductName());
            availData.setStockQty(product.getStockQty());
            

      return repo.save(product);
    } catch (Exception e) {
      e.printStackTrace();
      return availData;
    }
  }

  @Override
  public boolean deleteProduct(long productId) {
    try {
      repo.deleteById(productId);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
