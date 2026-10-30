package com.merchant.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface ClientRepository extends JpaRepository<ClientJpaEntity, Long> {

}