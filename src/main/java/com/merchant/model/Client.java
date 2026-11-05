package com.merchant.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Modèle du domaine : Java pur, sans aucune annotation JPA ni REST.
 * Le client ne connaît ses produits que par leur identifiant.
 */
public class Client {

    private Integer idClient;
    private String nom;
    private String prenom;
    private String email;
    private final Set<Integer> produitIds = new LinkedHashSet<>();

    public Client() {
    }

    public Client(Integer idClient, String nom, String prenom, String email, Collection<Integer> produitIds) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        remplacerProduits(produitIds);
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Integer> getProduitIds() {
        return produitIds;
    }

    // attention : c'est un remplacement de la liste, pas un enrichissement (doublons et null ignorés)
    public void remplacerProduits(Collection<Integer> ids) {
        this.produitIds.clear();
        if (ids != null) {
            for (Integer id : ids) {
                if (id != null) {
                    this.produitIds.add(id);
                }
            }
        }
    }

    public void addProduit(Integer produitId) {
        this.produitIds.add(produitId);
    }

    public void removeProduit(Integer produitId) {
        this.produitIds.remove(produitId);
    }
}
