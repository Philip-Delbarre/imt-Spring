package com.merchant.model;

import java.util.ArrayList;

public class Client {

    private int id;
    private String nom;
    private String prenom;
    private String eMail;
    private ArrayList<Produit> produits= new ArrayList<>(); //# on attache une liste de  plursiurs produit à un client !

    public Client (int idClient, String nom, String prenom, String eMail, ArrayList<Produit> produits) {
        this.id = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.eMail = eMail;
        this.produits = produits;
    }

    public int getIdClient() {
        return this.id;
    }

    public String getPrenom() {
        return prenom;
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


    public ArrayList<Produit> getProduits ()
    {
       return produits;}

    
}
