package com.coma.Billing.Process.model;

import java.time.LocalDateTime;

public class InvoiceGeneratedRes {

    private long invoiceNo;
    private float amountPaid;
    private String billerName;
    private LocalDateTime billedAt;


    public InvoiceGeneratedRes(long invoiceNo, float amountPaid, String billerName, LocalDateTime billedAt) {
        this.invoiceNo = invoiceNo;
        this.amountPaid = amountPaid;
        this.billerName = billerName;
        this.billedAt = billedAt;
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

    public InvoiceGeneratedRes() {
    }

    
}
