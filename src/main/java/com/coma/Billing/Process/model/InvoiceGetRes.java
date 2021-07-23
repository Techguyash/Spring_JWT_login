package com.coma.Billing.Process.model;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceGetRes 
{

    private long invoiceNo;
    private String billerName;
    private LocalDateTime billedAt;
    private float amountPaid;
    private float billedAmount;
    private float discount;
    private String paymentType;
    private String customerName;
    private List<InvoiceProducts> products;


    public InvoiceGetRes() {
    }


    public long getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getBillerName() {
        return this.billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public LocalDateTime getBilledAt() {
        return this.billedAt;
    }

    public void setBilledAt(LocalDateTime billedAt) {
        this.billedAt = billedAt;
    }

    public float getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public float getBilledAmount() {
        return this.billedAmount;
    }

    public void setBilledAmount(float billedAmount) {
        this.billedAmount = billedAmount;
    }

    public float getDiscount() {
        return this.discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<InvoiceProducts> getProducts() {
        return this.products;
    }

    public void setProducts(List<InvoiceProducts> products) {
        this.products = products;
    }



   


    
}
