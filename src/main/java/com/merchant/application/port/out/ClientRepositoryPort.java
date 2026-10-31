package com.merchant.application.port.out;

import java.util.ArrayList;

import com.merchant.model.Client;

public interface ClientRepositoryPort {
    ArrayList<Client> findAll();

    Client save(Client client);
}