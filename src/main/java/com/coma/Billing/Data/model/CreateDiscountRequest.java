package com.coma.Billing.Data.model;

public class CreateDiscountRequest {

    private String discountName;
    private String description;
    private int percentage;


    public CreateDiscountRequest() {
    }


    public CreateDiscountRequest(String discountName, String description, int percentage) {
        this.discountName = discountName;
        this.description = description;
        this.percentage = percentage;
    }


    public String getDiscountName() {
        return this.discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
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
