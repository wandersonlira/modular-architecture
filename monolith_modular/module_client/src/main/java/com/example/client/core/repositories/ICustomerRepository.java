package com.example.client.domain.repositories;

import com.example.client.domain.entities.Customer;

public interface ICustomerRepository {

    Customer save(Customer customer);
//    Optional<Customer> findById(Long id);
//    void delete(Long id);
}
