package com.coma.Billing.Process.model;


public class PurchaseInvReq {

    private String itemName;
    private float qty;
    private float price;
    private float total;
    private long billerId;
    private String paymentType;
   
  

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

    public long getBillerId() {
        return this.billerId;
    }

    public void setBillerId(long billerId) {
        this.billerId = billerId;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

   
    
}
