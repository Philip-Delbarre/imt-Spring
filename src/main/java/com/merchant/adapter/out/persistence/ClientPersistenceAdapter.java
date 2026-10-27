package com.merchant.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merchant.application.port.out.ClientRepositoryPort;
import com.merchant.domain.model.Client;

@Repository
public class ClientPersistenceAdapter implements ClientRepositoryPort {
    @Autowired 
    private ClientRepository repository;

    // retourne une lsite de client
    @Override
    public ArrayList <Client> findAll() {
        ArrayList <ClientJpaEntity> clientsBdd = repository.findAll();
        ArrayList <Client> clients = new ArrayList<>();
        for(ClientJpaEntity entity : clientsBdd) {
            clients.add(toDomain(entity));
        }
        return clients;
    }
    // enregistre des clients
    
    @Override
    public void save(Client client) {
        repository.save(new ClientJpaEntity(
                client.getId(), client.getNom(), client.getIdEmployes()));
    }

    private Client toDomain(ClientJpaEntity entity) {
        return new Client(entity.getId(), entity.getNom(), entity.getIdEmployes());
    }
}