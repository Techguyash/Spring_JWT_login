package com.coma.Billing.Process.model;

import java.util.List;




public class GenerateInvoiceReq {
/*
need individual product data
bill data
*/
   private List<InvoiceProducts> productsList;
    private float billedAmount;
    private long customerId;
    private long billerId;
    private String paymentType;
    private int tax;
    private int discount;



    public int getTax() {
        return this.tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    public GenerateInvoiceReq() {
    }

    public List<InvoiceProducts> getProductsList() {
        return this.productsList;
    }

    public void setProductsList(List<InvoiceProducts> productsList) {
        this.productsList = productsList;
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
