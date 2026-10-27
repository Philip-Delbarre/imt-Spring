package com.merchant.adapter.out.employe;

public class EmployeApiResponse {
    private int id;
    private String nom;

    public EmployeApiResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}