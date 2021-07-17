package com.coma.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;


@Entity
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
   @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   private List<Category> category=new ArrayList<Category>();


    public Products(long productId, String productName, float stockQty, float price, String description, LocalDate createdOn, Units unit, List<Category> category) {
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

    public List<Category> getCategory() {
        return this.category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public Products() {
    }

  
   
   

}
