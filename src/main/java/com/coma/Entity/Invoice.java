package com.coma.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_t")
public class Invoice
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceNo;
    private float billedAmount;
    private LocalDateTime billedAt;
    private String paymentType;
    private float discount;
    //amountPaid=billedAmount-discount;
    private float amountPaid;
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToOne
    @JoinColumn(name="billerNo")
    private AppUser biller;


    public Invoice(long invoiceNo, float billedAmount, LocalDateTime billedAt, String paymentType, float discount, float amountPaid, Customer customer, AppUser biller) {
        this.invoiceNo = invoiceNo;
        this.billedAmount = billedAmount;
        this.billedAt = billedAt;
        this.paymentType = paymentType;
        this.discount = discount;
        this.amountPaid = amountPaid;
        this.customer = customer;
        this.biller = biller;
    }


    public Invoice() {
    }


    public long getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
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

    public float getDiscount() {
        return this.discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AppUser getBiller() {
        return this.biller;
    }

    public void setBiller(AppUser biller) {
        this.biller = biller;
    }


    @Override
    public String toString() {
        return "{" +
            " invoiceNo='" + getInvoiceNo() + "'" +
            ", billedAmount='" + getBilledAmount() + "'" +
            ", billedAt='" + getBilledAt() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            ", discount='" + getDiscount() + "'" +
            ", amountPaid='" + getAmountPaid() + "'" +
            ", customer='" + getCustomer() + "'" +
            ", biller='" + getBiller() + "'" +
            "}";
    }




  
}
