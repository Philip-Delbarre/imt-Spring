package com.merchant.adapter.in.rest;

public class ProduitDTO {
    private int idProduct;
    private String productName;
    private String description;
    private float price;

    public ProduitDTO (int idProduct, String productName, String description, float price  ) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.description = description;
        this.price = price;

    }

    public int getIdProduct() {
        return this.idProduct;
    }

    public String getDescription() {
        return this.description;
    }

    public float getPrice() {
        return this.price;
    }

    public String getProductName() {
        return this.productName;
    }

      public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    

    public void setDescription (String description) {
        this.description = description ;
    }
    
    
}