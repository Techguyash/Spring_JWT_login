package com.coma.Billing.Data.model;

public class CreateCategoryRequest {

    
    private String categoryName;
    private String  description;

    public CreateCategoryRequest(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateCategoryRequest() {
    }
   
   
    
}
