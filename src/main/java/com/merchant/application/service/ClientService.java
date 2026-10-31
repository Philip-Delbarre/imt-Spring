package com.merchant.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.merchant.application.port.out.ClientRepositoryPort;
import com.merchant.model.Client;
import com.merchant.application.port.in.ClientServicePort;

@Component 
public class ClientService implements ClientServicePort {
    @Autowired 
    private ClientRepositoryPort clientRepositoryPort;

    @Override
    public ArrayList<Client> consulterClients() {
        return clientRepositoryPort.findAll();
    }

    @Override
    public Client creerClient(Client client) {
        return clientRepositoryPort.save(client);
    }
}