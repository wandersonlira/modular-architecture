package com.example.client.application.ports;

import com.example.client.application.mappers.RegisterCustomerUseCaseInput;
import com.example.client.application.mappers.RegisterCustomerUseCaseOutput;
import com.example.client.domain.entities.Customer;


public interface IRegisterCustomerUseCase {
   RegisterCustomerUseCaseOutput toExecute(RegisterCustomerUseCaseInput input);
   String registerClientUseCase(Customer customer);
}
