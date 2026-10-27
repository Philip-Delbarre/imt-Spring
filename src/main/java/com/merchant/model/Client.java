package com.merchant.model;

import java.util.ArrayList;

public class Client {

    private int id;
    private String nom;
    private String eMail;
    private ArrayList<Produit> produits; //# on attache une liste de  plursiurs produit à un client !

    public Client (int id, String nom, String prenom, String eMail, ArrayList<Produit> produits) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.eMail = eMail;
        this.produit = produits;
    }

    public int getId() {
        return this.id;
    }

    public String getPrenom() {
        return nom;
    }
    
    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return this.eMail;
    }
    // settings

    public void setEmail (String eMail) {
        this.eMail = eMail;
    }

    public void setPrenom  (String prenom ) {
        this.prenom = prenom;
    }
    
    public void setNom (String nom ) {
        this.nom = nom;
    }


    public ArrayList<String> getProduits ()
    {
       return produits;}

    
}
