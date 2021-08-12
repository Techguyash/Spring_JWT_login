package com.coma.Billing.Process.model;

import java.time.LocalDateTime;

public class GeneratedInvoiceRes {

    private long invoiceNo;
    private float amountPaid;
    private String billerName;
    private LocalDateTime billedAt;
    private int tax;
    private int discount;
    private String taxName;


    public String getTaxName() {
        return this.taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

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
    

    public long getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public float getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
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

    public GeneratedInvoiceRes() {
    }

    
}
