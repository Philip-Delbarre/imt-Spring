package com.merchant.application.port.out;

import java.util.ArrayList;

import com.merchant.model.Produit;

public interface ProduitPort {
    ArrayList<Produit> findByIds(ArrayList<Integer> ids);
}