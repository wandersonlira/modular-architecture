package com.example.client.application.usecases;

import com.example.client.application.abstractions.data.IAbstractionData;
import com.example.client.application.contracts.ISearchAllCustomerUseCase;
import com.example.client.core.domain.Customer;

import java.util.List;

final class SearchAllCustomerUseCase implements ISearchAllCustomerUseCase {
    private final IAbstractionData customerRepository;

    SearchAllCustomerUseCase(IAbstractionData customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> toExecute() {
        return customerRepository.findAll();
    }
}
