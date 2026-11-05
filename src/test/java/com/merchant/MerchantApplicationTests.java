package com.merchant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.merchant.model.Client;


// Mock VMC est essentiel piour tester les endpoints REST sans lancer le serveur complet. Il simule les requêtes HTTP et permet de vérifier les réponses.

@SpringBootTest
@AutoConfigureMockMvc
class MerchantApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreationClient() {
        Client clientFictif = new Client(12, "Doe", "John", "chat@fr", new ArrayList<>());

        assertEquals(12, clientFictif.getIdClient().intValue());
        assertEquals("Doe", clientFictif.getNom());
        assertEquals("John", clientFictif.getPrenom());
        assertEquals("chat@fr", clientFictif.getEmail());
        assertTrue(clientFictif.getProduitIds().isEmpty());
    }

// test endpoint produit controller

  @Test
    void testGetUserById() throws Exception {
        mockMvc.perform(get("/api/users/{id}", 123))
               .andExpect(status().isOk())
               .andExpect(content().string("User: 123"));
    }


    // tester une levée d'exception
    @Test
    void testGetUserByIdNotFound() throws Exception {
        mockMvc.perform(get("/api/users/{id}", 999))
               .andExpect(status().isNotFound())
               .andExpect(content().string("User not found"));  

    }
}