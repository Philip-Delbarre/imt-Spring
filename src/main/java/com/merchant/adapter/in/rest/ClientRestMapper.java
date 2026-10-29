package com.merchant.adapter.in.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.merchant.model.Produit;
import com.merchant.model.Client;

@Component
public class ClientRestMapper {
    public Client toDomain(CreationClientDTO dto) {
        ArrayList<Produit> id = new ArrayList<>();
        //controle pour savoir si les produits sont envoyés par postman, si rien alors on initialise une liste vide
        if(dto.getIdClient() != 0) {
            id.add( dto.getIdClient(), dto.getProduits().get(0));
        }
        return new Client(dto.getIdClient(), dto.getNom(), dto.getPrenom(), dto.getEmail(), dto.getProduits());
    }

    // la calsse ClientDTO n'est pas reconnue

    
    public ClientDTO toDto(Client client) {
        //ici on met new Arraylist dans les identifiants Produits car nous paramétrons les ProduitDTO 
        //dans un deuxième temps après avoir fait l'appel REST
        // int id, String nom, String prenom, String eMail, ArrayList<Produit> produits)
        return new ClientDTO(client.getIdClient(), client.getNom(), client.getPrenom(), client.getEmail(), new ArrayList<>());
    }

    public ProduitDTO toProduitDto(Produit produit) {
        return new ProduitDTO(produit.getIdProduct(), produit.getDescription(), produit.getProductName(), produit.getPrice());
    }


}