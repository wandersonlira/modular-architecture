package com.example.client.application.contracts;

import com.example.client.application.mappers.RegisterCustomerUseCaseInput;
import com.example.client.application.mappers.RegisterCustomerUseCaseOutput;
import com.example.client.core.domain.Customer;


public interface IRegisterCustomerUseCase {
   RegisterCustomerUseCaseOutput toExecute(RegisterCustomerUseCaseInput input);
   String registerClientUseCase(Customer customer);
}
