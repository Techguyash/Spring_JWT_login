package com.coma.Billing.Process.model;

public class InvoiceProducts 
{
        private long productId;
        private float qty;
        private float price;
        private float total;
        private String productName; 

        public String getProductName() {
                return this.productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }
        

        public InvoiceProducts(long productId, float qty, float price, float total) {
                this.productId = productId;
                this.qty = qty;
                this.price = price;
                this.total = total;
        }


        public InvoiceProducts() {
        }


        public long getProductId() {
                return this.productId;
        }

        public void setProductId(long productId) {
                this.productId = productId;
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
        
}
