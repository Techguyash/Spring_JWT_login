package com.coma.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;
    private String  description;
    private LocalDate createdOn;
    @ManyToMany(mappedBy = "category")
    private List<Products> product=new ArrayList<Products>();



    public Category() {
    }

    public Category(int categoryId, String categoryName, String description, LocalDate createdOn, List<Products> product) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.createdOn = createdOn;
        this.product = product;
    }


    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public LocalDate getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public List<Products> getProduct() {
        return this.product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
    }



}
