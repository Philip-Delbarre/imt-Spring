package com.merchant.adapter.in.rest;
import java.util.ArrayList;
import java.util.List;


public class ClientDTO {
    
 private int idClient;
    private String nom;
    private String prenom;
    private String eMail;
    private List<ProduitDTO> produits= new ArrayList<>(); //# on attache une liste de  plursiurs produit à un client !

    public ClientDTO (int idClient, String nom, String prenom, String eMail, List<ProduitDTO> produits) {
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

    public List<ProduitDTO> getProduits ()
    {
       return produits;}

    
}
