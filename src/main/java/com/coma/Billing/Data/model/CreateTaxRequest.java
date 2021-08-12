package com.coma.Billing.Data.model;

public class CreateTaxRequest {
    
    private String taxName;
    private String description;
    private int percentage;


    public CreateTaxRequest(String taxName, String description, int percentage) {
        this.taxName = taxName;
        this.description = description;
        this.percentage = percentage;
    }

    public CreateTaxRequest() {
    }

    public String getTaxName() {
        return this.taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

}
