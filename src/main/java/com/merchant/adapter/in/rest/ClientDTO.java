package com.merchant.adapter.in.rest;
import com.merchant.model.Produit;
import java.util.ArrayList;


public class ClientDTO {
    
 private int idClient;
    private String nom;
    private String prenom;
    private String eMail;
    private ArrayList<Produit> produits; //# on attache une liste de  plursiurs produit à un client !

    public ClientDTO (int idClient, String nom, String prenom, String eMail, ArrayList<Produit> produits) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.eMail = eMail;
        this.produits = produits;
    }

    public int getIdClient() {
        return this.idClient;
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


    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public ArrayList<Produit> getProduits ()
    {
       return produits;}

    
}
