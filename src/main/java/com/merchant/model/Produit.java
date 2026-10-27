package com.merchant.model;


public class Produit {
    private int id;
    private String produit;
    private String description;
    private float price;

    public Produit (int id, String produit, String description, float price ) {
        this.id = id;
        this.nom = produit;
        this.description = description ;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getProduit() {
        return this.produit;
    }

    public String getDescription() {
        return this.description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description ) {
        this.description = description;
    }

    public void setPrice (float price) {
        this.price = price;
    }

}
