package com.merchant.adapter.out.produit;

public class ProduitApiResponse {
    private int idProduct;
    private String productName;
    private String description;
    private float price;

   
    public ProduitApiResponse() {
    }



    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

  
}