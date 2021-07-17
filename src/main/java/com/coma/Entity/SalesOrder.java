package com.coma.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salesorder_t")
public class SalesOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long salesId;
    @ManyToMany
    private List<Products> product;
    private float qty;
    private float soldPrice;
    private float total;
    @ManyToOne
    @JoinColumn(name = "invoiceNo")
    private Invoice invoice;




    public SalesOrder() {
    }

    public SalesOrder(long salesId, List<Products> product, float qty, float soldPrice, float total, Invoice invoice) {
        this.salesId = salesId;
        this.product = product;
        this.qty = qty;
        this.soldPrice = soldPrice;
        this.total = total;
        this.invoice = invoice;
    }

    public long getSalesId() {
        return this.salesId;
    }

    public void setSalesId(long salesId) {
        this.salesId = salesId;
    }

    public List<Products> getProduct() {
        return this.product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
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

    public Invoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }


}
