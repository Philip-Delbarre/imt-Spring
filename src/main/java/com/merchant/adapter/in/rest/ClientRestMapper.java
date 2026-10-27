package com.merchant.adapter.in.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.domain.model.Produit;
import com.example.demo.domain.model.Client;

@Component
public class ClientRestMapper {
    public Client toDomain(CreationClientDTO dto) {
        List<Integer> idProduits = new ArrayList<>();
        //controle pour savoir si les employés sont envoyés par postman, si rien alors on initialise une liste vide
        if(dto.getIdProduits() != null) {
            idProduits.addAll(dto.getIdProduits());
        }
        return new Client(dto.getId(), dto.getNom(), idProduits);
    }

    public ClientDTO toDto(Client Client) {
        //ici on met new Arraylist dans les identifiants Produits car nous paramétrons les ProduitDTO 
        //dans un deuxième temps après avoir fait l'appel REST
        return new ClientDTO(Client.getId(), Client.getNom(), new ArrayList<>());
    }

    public ProduitDTO toProduitDto(Produit Produit) {
        return new ProduitDTO(Produit.getId(), Produit.getNom());
    }
}