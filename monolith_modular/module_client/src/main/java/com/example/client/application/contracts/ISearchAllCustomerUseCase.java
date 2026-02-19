package com.example.client.application.contracts;

import com.example.client.core.domain.Customer;

import java.util.List;

public interface ISearchAllCustomerUseCase {
    List<Customer> toExecute();
}
