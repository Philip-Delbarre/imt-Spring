package com.merchant.application.port.in;

import java.util.ArrayList;


import org.springframework.stereotype.Component;

import com.merchant.model.Client;

@Component
public interface ClientServicePort {
    ArrayList<Client> consulterClients();

    void creerClient(Client client);
}