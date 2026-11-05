package com.merchant.adapter.out.produit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.merchant.application.port.out.ProduitPort;
import com.merchant.dto.ProduitResponse;
import com.merchant.model.ProduitInfo;
import com.merchant.service.ProduitService;

/**
 * Adapter sortant : seul endroit où le module Client (hexagonal) connaît le module Produit (MVC).
 * Il appelle ProduitService directement, dans la même application : plus d'appel HTTP vers localhost:8081.
 * Si les deux deviennent un jour des microservices, il suffira de réécrire cette classe.
 */
@Component
public class ProduitAdapter implements ProduitPort {

    private final ProduitService produitService;

    public ProduitAdapter(ProduitService produitService) {
        this.produitService = produitService;
    }

    @Override
    public List<ProduitInfo> findByIds(Collection<Integer> idProduits) {
        List<ProduitInfo> resultat = new ArrayList<>();
        for (ProduitResponse produit : produitService.findByIds(idProduits)) {
            resultat.add(new ProduitInfo(produit.getIdProduit(), produit.getNomProduit(),
                    produit.getDesignation(), produit.getPrixUnitaire()));
        }
        return resultat;
    }
}
