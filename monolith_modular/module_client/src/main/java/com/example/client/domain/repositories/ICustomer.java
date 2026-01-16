package com.example.client.domain.repositories;

import com.example.client.domain.entities.Customer;

public interface ICustomer {
    Customer registerCustomer(Customer customer);
}
