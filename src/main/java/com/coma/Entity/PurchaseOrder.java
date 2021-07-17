package com.coma.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class PurchaseOrder
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long purchaseid;
    private float qty;
    private float purchasedPrice;
    private float total;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Products product;
    @ManyToOne
    @JoinColumn(name = "vendorid")
    private Vendor vendor;

    public PurchaseOrder() {
    }

    public PurchaseOrder(long purchaseid, float qty, float purchasedPrice, float total, Products product, Vendor vendor) {
        this.purchaseid = purchaseid;
        this.qty = qty;
        this.purchasedPrice = purchasedPrice;
        this.total = total;
        this.product = product;
        this.vendor = vendor;
    }

    public long getPurchaseid() {
        return this.purchaseid;
    }

    public void setPurchaseid(long purchaseid) {
        this.purchaseid = purchaseid;
    }

    public float getQty() {
        return this.qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public float getPurchasedPrice() {
        return this.purchasedPrice;
    }

    public void setPurchasedPrice(float purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Products getProduct() {
        return this.product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    

}
