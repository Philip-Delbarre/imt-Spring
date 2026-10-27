package com.example.demo.application.port.in;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.domain.model.Entreprise;

@Component
public interface EntrepriseServicePort {
    List<Entreprise> consulterEntreprises();

    void creerEntreprise(Entreprise entreprise);
}