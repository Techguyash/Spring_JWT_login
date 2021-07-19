package com.coma.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int categoryId;

  private String categoryName;
  private String description;
  private LocalDate createdOn;

  public Category() {}

  public Category(
    int categoryId,
    String categoryName,
    String description,
    LocalDate createdOn
  ) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.description = description;
    this.createdOn = createdOn;
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
}
