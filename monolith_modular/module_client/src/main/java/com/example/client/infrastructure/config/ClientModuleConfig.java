package com.example.client.infrastructure.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example.client")
@EntityScan(basePackages = "com.example.client.infrastructure.persistence")
@EnableJpaRepositories(basePackages = "com.example.client.infrastructure.persistence")
public class ClientModuleConfig {

//    @Bean
//    public RegisterCustomerUseCase registerCustomerUseCase(ICustomerRepository customerRepository) {
//        return new RegisterCustomerUseCase(customerRepository);
//    }

}