package com.example.demo.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.application.port.out.EntrepriseRepositoryPort;
import com.example.demo.domain.model.Entreprise;
import com.example.demo.application.port.in.EntrepriseServicePort;

@Component 
public class EntrepriseService implements EntrepriseServicePort {
    @Autowired 
    private EntrepriseRepositoryPort entrepriseRepository;

    @Override
    public List<Entreprise> consulterEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public void creerEntreprise(Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
    }
}