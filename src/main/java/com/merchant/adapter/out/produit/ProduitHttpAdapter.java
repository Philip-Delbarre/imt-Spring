package com.merchant.adapter.out.produit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.merchant.application.port.out.ProduitPort;
import com.merchant.model.Produit;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
public class ProduitHttpAdapter implements ProduitPort {

    @Override
    public List<Produit> findByIds(List<Integer> idEmployes) {
        //décalration de l'objet permettant de déclencher un appel REST
        Client client = ClientBuilder.newClient();
        //on paramtre le lien d'appel, notre module Employe
        WebTarget target = client.target("http://localhost:8081/api/employes");

        // Ajout des query params représentant les identifiants d'employés
        for (Integer id : idEmployes) {
            target = target.queryParam("idEmployes", id);
        }

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        //ici, cela nous permet de convertir directement la réponse du webservice en objet EmployeDAO
        List<ProduitApiResponse> produits = response.readEntity(new GenericType<ArrayList<ProduitApiResponse>>() {});
        response.close();
        client.close();

        //on map les employes de l'API Employe en employes de notre domaine
        ArrayList<Produit> produitsDomain = new ArrayList<>();
        for (ProduitApiResponse produit : produits) {

            // String productName, String description, float price 
            produitsDomain.add(new Produit(produit.getIdProduct(), produit.getProductName(), produit.getDescription(), produit.getPrice()));
        }
        return produitsDomain;
    }
}