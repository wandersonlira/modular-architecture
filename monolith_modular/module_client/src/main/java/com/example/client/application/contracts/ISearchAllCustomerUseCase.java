package com.example.client.application.contracts;

import com.example.client.application.mappers.RegisterCustomerUseCaseOutput;
import com.example.client.domain.entities.Customer;

import java.util.List;

public interface ISearchAllCustomerUseCase {
    List<Customer> toExecute();
}
