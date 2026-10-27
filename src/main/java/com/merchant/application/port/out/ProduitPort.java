package com.merchant.application.port.out;

import java.util.List;

import com.merchant.model.Produit;

public interface ProduitPort {
    List<Produit> findByIds(List<Integer> ids);
}