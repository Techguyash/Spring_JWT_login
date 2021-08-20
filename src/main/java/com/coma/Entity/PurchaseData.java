package com.coma.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PurchaseData 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int purchaseId;
    private String itemName;
    private float qty;
    private float price;
    private float total;
    private LocalDate purchasedOn;
    @OneToOne 
    private AppUser purchasedBy;
    private String paymentType;
    

    public int getPurchaseId() {
        return this.purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getQty() {
        return this.qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getPurchasedOn() {
        return this.purchasedOn;
    }

    public void setPurchasedOn(LocalDate purchasedOn) {
        this.purchasedOn = purchasedOn;
    }

    public AppUser getPurchasedBy() {
        return this.purchasedBy;
    }

    public void setPurchasedBy(AppUser purchasedBy) {
        this.purchasedBy = purchasedBy;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

  


    public PurchaseData() {
    }


    public PurchaseData(int purchaseId, String itemName, float qty, float price, float total, LocalDate purchasedOn, AppUser purchasedBy, String paymentType) {
        this.purchaseId = purchaseId;
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
        this.total = total;
        this.purchasedOn = purchasedOn;
        this.purchasedBy = purchasedBy;
        this.paymentType = paymentType;
      
    }



    
}
