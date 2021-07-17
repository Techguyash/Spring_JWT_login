package com.coma.Entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_t")
public class Invoice
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceNo;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<SalesOrder> salesOrder;
    private float billedAmount;
    private LocalDateTime billedAt;
    private String paymentType;
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;


    public Invoice(long invoiceNo, List<SalesOrder> salesOrder, float billedAmount, LocalDateTime billedAt, String paymentType, Customer customer) {
        this.invoiceNo = invoiceNo;
        this.salesOrder = salesOrder;
        this.billedAmount = billedAmount;
        this.billedAt = billedAt;
        this.paymentType = paymentType;
        this.customer = customer;
    }


    public long getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public List<SalesOrder> getSalesOrder() {
        return this.salesOrder;
    }

    public void setSalesOrder(List<SalesOrder> salesOrder) {
        this.salesOrder = salesOrder;
    }

    public float getBilledAmount() {
        return this.billedAmount;
    }

    public void setBilledAmount(float billedAmount) {
        this.billedAmount = billedAmount;
    }

    public LocalDateTime getBilledAt() {
        return this.billedAt;
    }

    public void setBilledAt(LocalDateTime billedAt) {
        this.billedAt = billedAt;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Invoice() {
    }

    
    
    
    
}
