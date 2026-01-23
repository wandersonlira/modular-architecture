package com.example.client.infrastructure.persistence.impl;

import com.example.client.domain.entities.Customer;
import com.example.client.domain.repositories.ICustomerRepository;
import com.example.client.infrastructure.persistence.model.CustomerEntity;
import com.example.client.infrastructure.persistence.repositories.ICustomerJpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {
    private final ICustomerJpaRepository repository;


    protected CustomerRepositoryImpl(ICustomerJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = new CustomerEntity(customer.getName(), customer.getSex(), customer.getCity());
        this.repository.save(entity);
        return customer;
    }
}