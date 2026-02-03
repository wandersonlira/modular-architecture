package com.example.client.application.abstractions.data;

import com.example.client.core.domain.Customer;

import java.util.List;

public interface IAbstractionData /*extends ICustomerRepository*/ {
    Customer save(Customer customer);
    List<Customer> findAll();
//    Optional<Customer> findById(Long id);
//    void delete(Long id);
}
