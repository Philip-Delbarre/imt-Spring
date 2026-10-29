package com.merchant.adapter.out.persistence;

import java.util.ArrayList;

import com.merchant.model.Produit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idClient;
    private String nom;
    private String prenom;
    private String eMail;
    private ArrayList <Produit> produits = new ArrayList<>();

    protected ClientJpaEntity() {
    }

    public ClientJpaEntity(int idClient, String nom, String prenom, String eMail, ArrayList<Produit> produits) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.eMail = eMail;
        this.produits = produits;
    }

    public int getIdClient() {
        return idClient;
    }

     public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }

     public String geteMail() {
        return eMail;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }
}