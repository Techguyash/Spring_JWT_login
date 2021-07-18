package com.coma.Billing.Data.model;

public class CreateProductRequest {
    private String productName;
    private float stockQty;
    private float price;
    private String description;
    private int unitId;
   private int categoryId;


    public CreateProductRequest(String productName, float stockQty, float price, String description, int unitId, int categoryId) {
        this.productName = productName;
        this.stockQty = stockQty;
        this.price = price;
        this.description = description;
        this.unitId = unitId;
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getStockQty() {
        return this.stockQty;
    }

    public void setStockQty(float stockQty) {
        this.stockQty = stockQty;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitId() {
        return this.unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public CreateProductRequest() {
    }


}
