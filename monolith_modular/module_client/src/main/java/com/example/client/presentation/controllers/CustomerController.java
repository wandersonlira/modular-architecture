package com.example.client.presentation.controllers;

import com.example.client.presentation.dtos.RegisterCustomerRequestDTO;
import com.example.client.application.mappers.RegisterCustomerUseCaseInput;
import com.example.client.application.contracts.IRegisterCustomerUseCase;
import com.example.client.domain.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
 final class CustomerController {
    private final IRegisterCustomerUseCase registerCustomerUseCase;


    private CustomerController(IRegisterCustomerUseCase registerCustomerUseCase) {
        this.registerCustomerUseCase = registerCustomerUseCase;
    }


    @PostMapping(path = "/register")
    private ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(registerCustomerUseCase.registerClientUseCase(customer));
    }

    @PostMapping(path = "/registerjpa")
    private ResponseEntity<?> registerCustomerJpa(@RequestBody RegisterCustomerRequestDTO request) {
        RegisterCustomerUseCaseInput input = new RegisterCustomerUseCaseInput(request.name(), request.email(), request.city(), request.gender());
        return ResponseEntity.status(HttpStatus.OK).body(registerCustomerUseCase.toExecute(input));
    }

}
