package com.merchant.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merchant.model.Produit;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<ClientJpaEntity, Long> {

    @Query("""
        SELECT c
        FROM ClientJpaEntity c
        WHERE (:page IS NULL OR c.id >= :page)
          AND (:nom IS NULL OR LOWER(c.nom) LIKE LOWER(CONCAT('%', :nom, '%')))
          AND (:prenom IS NULL OR LOWER(c.prenom) LIKE LOWER(CONCAT('%', :prenom, '%')))
          AND (:email IS NULL OR LOWER(c.email) LIKE LOWER(CONCAT('%', :email, '%')))
        """)
    ArrayList<ClientJpaEntity> searchClients(
        @Param("page") int page,
        @Param("nom") String nom,
        @Param("prenom") String prenom,
        @Param("email") String email,
        @Param("filtres") ArrayList<String> filtres
    );
}