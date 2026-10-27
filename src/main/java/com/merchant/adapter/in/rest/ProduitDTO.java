package com.merchant.adapter.in.rest;

public class ProduitDTO {
    private int id;
    private String produit;
    private String description;
    private float price;

    public Produit (int id, String produit, String description, float price  ) {
        this.id = id;
        this.produit = produit;
        this.description = description;
        this.price = price;

    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPrice() {
        return this.price;
    }

    public void setId(int id) {
        this.id = id;
    }

      public String getProduit() {
        return this.produit;
    }

    public void setDescription (String description) {
        this.description = description ;
    }
    
    
}