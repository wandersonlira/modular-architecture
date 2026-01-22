package com.example.client.infrastructure.persistence.repositories;

import com.example.client.infrastructure.persistence.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {}
