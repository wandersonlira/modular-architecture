package com.example.client.infrastructure.config;


import com.example.client.application.abstractions.data.IAbstractionData;
import com.example.client.application.contracts.IRegisterCustomerUseCase;
import com.example.client.application.contracts.ISearchAllCustomerUseCase;
import com.example.client.application.usecases.UseCaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class UseCaseConfig {

    @Bean
    IRegisterCustomerUseCase registerCustomerUseCase(IAbstractionData repository) {
        return UseCaseFactory.createRegisterCustomer(repository);
    }

    @Bean
    ISearchAllCustomerUseCase searchAllCustomer(IAbstractionData repository) {
        return UseCaseFactory.createSearchAll(repository);
    }
}
