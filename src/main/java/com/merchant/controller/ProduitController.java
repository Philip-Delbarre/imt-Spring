package com.merchant.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.merchant.dto.ProduitRequest;
import com.merchant.dto.ProduitResponse;
import com.merchant.exception.BadRequestException;
import com.merchant.service.ProduitService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

/**
 * Contrôleur (C) du MVC : expose les produits sur /api/produits.
 * Il utilise Jakarta REST (Jersey) et non Spring MVC : Jersey occupe déjà tout /api/*,
 * un @RestController Spring placé sous /api ne serait jamais atteint (404).
 */
@Component
@Path("produits")
@Produces(MediaType.APPLICATION_JSON)
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GET
    public List<ProduitResponse> getAll() {
        return produitService.findAll();
    }

    @GET
    @Path("{id}")
    public ProduitResponse getById(@PathParam("id") int id) {
        return produitService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ProduitRequest request, @Context UriInfo uriInfo) {
        verifierCorps(request);
        ProduitResponse cree = produitService.create(request);
        URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(cree.getIdProduit())).build();
        return Response.created(location).entity(cree).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ProduitResponse update(@PathParam("id") int id, ProduitRequest request) {
        verifierCorps(request);
        return produitService.update(id, request);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
        produitService.delete(id);
    }

    private void verifierCorps(ProduitRequest request) {
        if (request == null) {
            throw new BadRequestException("Corps de requête manquant");
        }
        // contrôle des champs obligatoires (nom du produit, prix)
        request.verifier();
    }
}
