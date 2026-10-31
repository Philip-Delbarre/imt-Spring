package com.merchant.adapter.out.persistence;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merchant.application.port.out.ClientRepositoryPort;
import com.merchant.model.Client;

@Repository
public class ClientPersistenceAdapter implements ClientRepositoryPort {
    @Autowired 
    private ClientRepository repository;

    // retourne une lsite de client
    @Override
    public ArrayList <Client> findAll() {
        ArrayList <ClientJpaEntity> clientsBdd = (ArrayList<ClientJpaEntity>) repository.findAll();
        ArrayList <Client> clients = new ArrayList<>();
        for(ClientJpaEntity entity : clientsBdd) {
            clients.add(toDomain(entity));
        }
        return clients;
    }
    // enregistre des clients
    
    @Override
    public Client save(Client client) {
        ClientJpaEntity entity = new ClientJpaEntity(
                client.getIdClient(), client.getNom(), client.getPrenom(), client.getEmail(), client.getProduits());
        ClientJpaEntity entitySauvegardee = repository.save(entity);
        return toDomain(entitySauvegardee);
    }

    private Client toDomain(ClientJpaEntity entity) {
        return new Client(entity.getIdClient(), entity.getNom(), entity.getPrenom(), entity.geteMail(), entity.getProduits());
    }
}