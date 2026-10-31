package com.merchant.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface ClientRepository extends JpaRepository<ClientJpaEntity, Integer> {
}