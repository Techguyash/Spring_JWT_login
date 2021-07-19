package com.coma.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Products
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private float stockQty;
    private float price;
    private String description;
    private LocalDate createdOn;
   @OneToOne
   @JoinColumn(name = "unitId")
    private Units unit;
   @OneToOne
   
   private Category category;


    public Products( String productName, float stockQty, float price, String description, LocalDate createdOn, Units unit, Category category) {
        this.productName = productName;
        this.stockQty = stockQty;
        this.price = price;
        this.description = description;
        this.createdOn = createdOn;
        this.unit = unit;
        this.category = category;
    }

    public Products(long productId, String productName, float stockQty, float price, String description, LocalDate createdOn, Units unit, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.stockQty = stockQty;
        this.price = price;
        this.description = description;
        this.createdOn = createdOn;
        this.unit = unit;
        this.category = category;
    }


    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public LocalDate getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public Units getUnit() {
        return this.unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Products() {
    }

  
   
   

}
