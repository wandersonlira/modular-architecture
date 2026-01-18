package com.example.client.Gateway;

import com.example.client.domain.entities.Customer;

public interface ICustomerGateway {
    Customer saveCustomer(Customer customer);
}
