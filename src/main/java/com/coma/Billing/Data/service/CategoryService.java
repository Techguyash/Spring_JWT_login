package com.coma.Billing.Data.service;

import java.util.List;

import com.coma.Billing.Data.model.CreateCategoryRequest;
import com.coma.Entity.Category;

public interface CategoryService {

    Category createCategory(CreateCategoryRequest category);
    Category getCategory(int id);
   List<Category> getAllCategorys();
   Category updateCategory(Category category);
   boolean deleteCategory(int Id);
    
}
