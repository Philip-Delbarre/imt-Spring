package com.merchant.adapter.in.rest;

import java.util.ArrayList;
import com.merchant.model.Produit;

public class CreationClientDTO {
    private int idClient;
    private String nom;
    private String prenom;
    private String eMail;
    private ArrayList<Produit> produits; //# on attache une liste de  plursiurs produit à un client !

    public CreationClientDTO (int idClient, String nom, String prenom, String eMail, ArrayList<Produit> produits) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.eMail = eMail;
        this.produits = produits;
    }
    
    public CreationClientDTO() { // le constructeur est vide , !!!!!!
    }

    // dans cette classe les setters et les getters ne font pas appel à l'objet courant pourquoi ? 

    public int getIdClient() {
        return idClient;
    }

    public void setId(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

     public String getPrenom () {
        return prenom;
    }

    public String getEmail () {
        return eMail;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }

    public  ArrayList <Produit> getProduits() {
        return produits;
    }

    // attention c'est une affectation pas un enrichissmetn de liste !

    public void setProduits (ArrayList<Produit> produits ) {
        this.produits = produits ;
    }
}