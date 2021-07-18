package com.coma.Billing.Data.service;

import com.coma.Billing.Data.model.CreateCategoryRequest;
import com.coma.Entity.Category;
import com.coma.Repository.CategoryRepo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService_Impl implements CategoryService {

  @Autowired
  CategoryRepo catRepo;

  @Override
  public Category createCategory(CreateCategoryRequest req) {
    try {
      List<Category> availableCategory = getAllCategorys();

      for (Category cate : availableCategory) {
        if (cate.getCategoryName().equals(req.getCategoryName())) {
          throw new Exception("Value already availble");
        }
      }

      Category entity = new Category();
      entity.setCategoryName(req.getCategoryName());
      entity.setCreatedOn(LocalDate.now());
      entity.setDescription(req.getDescription());
      return catRepo.save(entity);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Category getCategory(int id) {
    return catRepo.getById(id);
  }

  @Override
  public List<Category> getAllCategorys() {
    return catRepo.findAll();
  }

  @Override
  public Category updateCategory(Category category) {
    try {
      Category foundCategory = getCategory(category.getCategoryId());
      foundCategory.setCategoryName(category.getCategoryName());
      foundCategory.setDescription(category.getDescription());
      return foundCategory;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean deleteCategory(int Id) {
    try {
      catRepo.deleteById(Id);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }


}
