package com.merchant.adapter.in.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.application.port.in.ClientServicePort;
import com.example.demo.application.port.out.EmployePort;
import com.example.demo.domain.model.Employe;
import com.merchant.model.Produit;
import com.example.demo.domain.model.Client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Component
@Path("clients")
@Produces("application/json")
public class ClientPresentation {
    @Autowired
    private ClientServicePort ClientServicePort;
    @Autowired 
    private ProduitPort produitServicePort;
    private ClientRestMapper mapper = new ClientRestMapper();

    @GET
    public List<ClientDTO> getClients() {
        List<Client> ClientsBdd = ClientServicePort.consulterClients();
        //cette liste nous sert d'objet de retour
        List<ClientDTO> ClientsRetournees = new ArrayList<>();
        //dans cette partie, on transforme les données en ClientDTO
        for(Client client : ClientsBdd){
            ClientDTO ClientAAjouter = mapper.toDto(client);
            //partie Employes, on va interroger le module Employe 
            //et mettre à dispo les infos employés dans chaque Client
            if(!client.getIdProduits().isEmpty()){
                //ici onfait l'appel au module Employe via la couche application 
                List<Produit> produits = produitServicePort.findByIds(client.getIdProduits());
                //on map les employés dans l'objet de retour associé et on l'ajoute à son Client
                for(Produit produit : produits){
                    ProduitDTO produitDTO = mapper.toProduitDto(produit);
                    ClientAAjouter.getProduit().add(produitDTO);
                }
            }
            //on ajoute l'Client mappée dans le résultat de la requête
            ClientsRetournees.add(ClientAAjouter);
        }
        return ClientsRetournees;
    }

    @POST
    @Consumes("application/json")
    public void creationClient(CreationClientDTO ClientDTO) {
        ClientServicePort.creerClient(mapper.toDomain(ClientDTO));
    }
}