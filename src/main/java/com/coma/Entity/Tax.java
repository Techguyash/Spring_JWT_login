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
public class Tax {

    
    @SequenceGenerator(name = "Seq_taxId",initialValue = 1,sequenceName = "Seq_taxId")

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Seq_taxId")
    private int id;
    @NotNull
    private String taxName;
    @NotNull
    private int percentage;
    @NotNull
    private String description;
    private LocalDate createdAt;
    private boolean enabled;

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    public Tax() {
    }




    public Tax( String taxName, int percentage, String description, LocalDate createdAt, boolean enabled) {
       
        this.taxName = taxName;
        this.percentage = percentage;
        this.description = description;
        this.createdAt = createdAt;
        this.enabled = enabled;
    }

    public Tax(int id, String taxName, int percentage, String description, LocalDate createdAt, boolean enabled) {
        this.id = id;
        this.taxName = taxName;
        this.percentage = percentage;
        this.description = description;
        this.createdAt = createdAt;
        this.enabled = enabled;
    }



    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

  




    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxName() {
        return this.taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
