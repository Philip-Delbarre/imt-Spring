package com.merchant.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.application.port.out.ClientRepositoryPort;
import com.example.demo.domain.model.Client;

@Repository
public class ClientPersistenceAdapter implements ClientRepositoryPort {
    @Autowired 
    private ClientRepository repository;

    @Override
    public List<Client> findAll() {
        List<ClientJpaEntity> clientsBdd = repository.findAll();
        List<Client> clients = new ArrayList<>();
        for(ClientJpaEntity entity : clientsBdd) {
            clients.add(toDomain(entity));
        }
        return clients;
    }

    @Override
    public void save(Client client) {
        repository.save(new ClientJpaEntity(
                client.getId(), client.getNom(), client.getIdEmployes()));
    }

    private Client toDomain(ClientJpaEntity entity) {
        return new Client(entity.getId(), entity.getNom(), entity.getIdEmployes());
    }
}