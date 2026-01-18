package com.example.client.application.ports;

import com.example.client.application.dtos.RegisterCustomerUseCaseInput;
import com.example.client.application.dtos.RegisterCustomerUseCaseOutput;
import com.example.client.domain.entities.Customer;


public interface IRegisterCustomerUseCase {
   RegisterCustomerUseCaseOutput toExecute(RegisterCustomerUseCaseInput input);
   String registerClientUseCase(Customer customer);
}
