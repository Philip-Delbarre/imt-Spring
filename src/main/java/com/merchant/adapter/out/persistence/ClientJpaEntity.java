package com.merchant.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import com.merchant.model.Produit;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @ElementCollection
    @CollectionTable(name = "client_produits", joinColumns = @JoinColumn(name = "client_id"))
    private List<Produit> produits = new ArrayList<>();

    protected ClientJpaEntity() {
    }

    public ClientJpaEntity(int idClient, String nom, String prenom, String eMail, List<Produit> produits) {
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

    public List<Produit> getProduits() {
        return produits;
    }
}