package com.coma.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Discount {

    @SequenceGenerator(name = "Seq_discountId",initialValue = 0,sequenceName = "Seq_discountId")

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Seq_discountId")
    private int id;
    @NotNull
    private String discountName;
    @NotNull
    private int percentageVal;
    @NotNull
    private String description;
    private LocalDate createdAt;
    private boolean enabled;





    public Discount() {
    }


    public Discount(int id, String discountName, int percentageVal, String description, LocalDate createdAt, boolean enabled) {
        this.id = id;
        this.discountName = discountName;
        this.percentageVal = percentageVal;
        this.description = description;
        this.createdAt = createdAt;
        this.enabled = enabled;
    }
  


    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscountName() {
        return this.discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public int getPercentageVal() {
        return this.percentageVal;
    }

    public void setPercentageVal(int percentageVal) {
        this.percentageVal = percentageVal;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


}
