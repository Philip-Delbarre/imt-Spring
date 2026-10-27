package com.merchant.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entreprises")
public class EntrepriseJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;

    private List<Integer> idEmployes = new ArrayList<>();

    protected EntrepriseJpaEntity() {
    }

    public EntrepriseJpaEntity(int id, String nom, List<Integer> idEmployes) {
        this.id = id;
        this.nom = nom;
        this.idEmployes = new ArrayList<>(idEmployes);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Integer> getIdEmployes() {
        return idEmployes;
    }
}