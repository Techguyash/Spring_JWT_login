package com.coma.Billing.Process.model;

public class InvoiceProductListReq 
{
        private int productId;
        private float qty;
        private float price;
        private float total; 
        

        public InvoiceProductListReq(int productId, float qty, float price, float total) {
                this.productId = productId;
                this.qty = qty;
                this.price = price;
                this.total = total;
        }


        public InvoiceProductListReq() {
        }


        public int getProductId() {
                return this.productId;
        }

        public void setProductId(int productId) {
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
