package com.example.client.application.usecases;


import com.example.client.Gateway.ICustomerGateway;
import com.example.client.application.dtos.RegisterCustomerUseCaseInput;
import com.example.client.application.dtos.RegisterCustomerUseCaseOutput;
import com.example.client.application.ports.IRegisterCustomerUseCase;
import com.example.client.domain.entities.Customer;
import com.example.client.domain.value_objects.Email;
import com.example.client.domain.value_objects.Gender;


public class RegisterCustomerUseCase  implements IRegisterCustomerUseCase {
private final ICustomerGateway customerGateway;


    public RegisterCustomerUseCase(ICustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }


    @Override
    public RegisterCustomerUseCaseOutput toExecute(RegisterCustomerUseCaseInput input) {
        Email email = new Email("wandersonlira@mv.com.br");
        Customer customer = new Customer(input.name(), Gender.valueOf(input.gender()), email, input.city());
//        customer.activateCustomer();
        Customer saved = customerGateway.saveCustomer(customer);
        return new RegisterCustomerUseCaseOutput(saved.getName(), saved.getEmail(), saved.getCity(), saved.getSex().name(), saved.getStatusCustomer().toString());
    }

    @Override
    public String registerClientUseCase(Customer customer) {
        return "Hello Word: Client registered \n" +
                customer.toString();
    }

}
