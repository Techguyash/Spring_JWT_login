package com.coma.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salesorder_t")
public class SalesOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long salesId;
    @OneToOne
    @JoinColumn(name = "productId")
    private Products product;
    @OneToOne
    @JoinColumn(name = "invoiceNo")
    private Invoice invoice;
    private float qty;
    private float soldPrice;
    private float total;


    public SalesOrder(long salesId, Products product, Invoice invoice, float qty, float soldPrice, float total) {
        this.salesId = salesId;
        this.product = product;
        this.invoice = invoice;
        this.qty = qty;
        this.soldPrice = soldPrice;
        this.total = total;
    }

    public SalesOrder() {
    }

    public long getSalesId() {
        return this.salesId;
    }

    public void setSalesId(long salesId) {
        this.salesId = salesId;
    }

    public Products getProduct() {
        return this.product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public float getQty() {
        return this.qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public float getSoldPrice() {
        return this.soldPrice;
    }

    public void setSoldPrice(float soldPrice) {
        this.soldPrice = soldPrice;
    }

    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

   
   




  
}
