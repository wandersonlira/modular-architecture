package com.example.client.application.usecases;

import com.example.client.application.abstractions.data.IAbstractionData;
import com.example.client.application.contracts.IRegisterCustomerUseCase;
import com.example.client.application.contracts.ISearchAllCustomerUseCase;


public final class UseCaseFactory {

    public static IRegisterCustomerUseCase createRegisterCustomer(IAbstractionData repository) {
        return new RegisterCustomerUseCase(repository);
    }

    public static ISearchAllCustomerUseCase createSearchAll(IAbstractionData repository) {
        return new SearchAllCustomerUseCase(repository);
    }
}
