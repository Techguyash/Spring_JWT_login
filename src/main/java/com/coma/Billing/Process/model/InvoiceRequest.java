package com.coma.Billing.Process.model;

import java.util.List;



public class InvoiceRequest {
/*
need individual product data
bill data
*/
   private List<InvoiceProductListReq> productsList;
    private float discount;
    private float billedAmount;
    private long customerId;
    private long billerId;
    private String paymentType;



    public InvoiceRequest(List<InvoiceProductListReq> productsList, float discount, float billedAmount, long customerId, long billerId, String paymentType) {
        this.productsList = productsList;
        this.discount = discount;
        this.billedAmount = billedAmount;
        this.customerId = customerId;
        this.billerId = billerId;
        this.paymentType = paymentType;
    }


    public InvoiceRequest() {
    }

    public List<InvoiceProductListReq> getProductsList() {
        return this.productsList;
    }

    public void setProductsList(List<InvoiceProductListReq> productsList) {
        this.productsList = productsList;
    }

    public float getDiscount() {
        return this.discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getBilledAmount() {
        return this.billedAmount;
    }

    public void setBilledAmount(float billedAmount) {
        this.billedAmount = billedAmount;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getBillerId() {
        return this.billerId;
    }

    public void setBillerId(long billerId) {
        this.billerId = billerId;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    
}
