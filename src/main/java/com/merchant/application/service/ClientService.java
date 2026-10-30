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
    private ClientRepositoryPort ClientRepository; 

    @Override
    public ArrayList<Client> consulterClients() {
        return ClientRepository.findAll();
    }

    public void creerClient(Client client) {
        ClientRepository.save(client);
    }
}