package com.coma.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "invoice_t")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Invoice
{
    
    @SequenceGenerator(name = "Seq_InvoiceNumber",initialValue = 1,sequenceName = "Seq_InvoiceNumber")

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Seq_InvoiceNumber")
    private long invoiceNo;
    private float billedAmount;
    private LocalDateTime billedAt;
    private String paymentType;
    //amountPaid=billedAmount-discount;
    private float amountPaid;
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToOne
    @JoinColumn(name="billerNo")
    private AppUser biller;
    @OneToOne
    private Discount discount;
    @OneToOne
    private Tax tax;


    public Invoice(long invoiceNo, float billedAmount, LocalDateTime billedAt, String paymentType, Discount discount, float amountPaid, Customer customer, AppUser biller) {
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


    public Tax getTax() {
        return this.tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }


    public Discount getDiscount() {
        return this.discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
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
            ", amountPaid='" + getAmountPaid() + "'" +
            ", customer='" + getCustomer() + "'" +
            ", biller='" + getBiller() + "'" +
            ", discount='" + getDiscount() + "'" +
            ", tax='" + getTax() + "'" +
            "}";
    }
 




  
}
