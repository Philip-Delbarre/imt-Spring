package com.merchant.application.port.in;

import java.util.ArrayList;

import com.merchant.model.Client;

public interface ClientServicePort {
    ArrayList<Client> consulterClients();

    Client creerClient(Client client);
}