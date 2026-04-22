package com.example.client.infrastructure.persistence.impl;

import com.example.client.application.abstractions.data.IAbstractionData;
import com.example.client.core.domain.Customer;
import com.example.client.core.value_objects.Email;
import com.example.client.infrastructure.persistence.entities.CustomerEntity;
import com.example.client.infrastructure.persistence.repositories.ICustomerJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
class CustomerRepositoryImpl implements IAbstractionData {
    private final ICustomerJpaRepository repository;


    CustomerRepositoryImpl(ICustomerJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = new CustomerEntity(customer.getName(), customer.getSex(), customer.getCity());
        this.repository.save(entity);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customersEntities = this.repository.findAll();
        Email email = new Email("wandersonlira@lira.com.br");
        return customersEntities.stream()
                .map(entity -> new Customer(
                        entity.getName(),
                        entity.getSex(),
                        email,
                        entity.getCity()
                ))
                .collect(Collectors.toList());
    }
}