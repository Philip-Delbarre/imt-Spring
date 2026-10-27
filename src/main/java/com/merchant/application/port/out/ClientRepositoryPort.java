package com.example.demo.application.port.out;

import java.util.List;

import com.example.demo.domain.model.Client;

public interface ClientRepositoryPort {
    ArrayList<Client> findAll();

    void save(Client client);
}