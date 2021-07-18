package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Billing.Data.model.CreateProductRequest;
import com.coma.Entity.Products;

public interface ProductService {

    Products createProduct(CreateProductRequest product);
     Products getProduct(long id);
    List<Products> getAllProducts();
    Products updateProduct(Products product);
    boolean deleteProduct(long productId);
    
}
