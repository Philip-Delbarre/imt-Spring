package com.merchant.adapter.out.employe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.application.port.out.EmployePort;
import com.example.demo.domain.model.Employe;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
public class EmployeHttpAdapter implements EmployePort {

    @Override
    public List<Employe> findByIds(List<Integer> idEmployes) {
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
        List<EmployeApiResponse> employes = response.readEntity(new GenericType<List<EmployeApiResponse>>() {});
        response.close();
        client.close();

        //on map les employes de l'API Employe en employes de notre domaine
        List<Employe> employesDomain = new ArrayList<>();
        for (EmployeApiResponse employe : employes) {
            employesDomain.add(new Employe(employe.getId(), employe.getNom()));
        }
        return employesDomain;
    }
}