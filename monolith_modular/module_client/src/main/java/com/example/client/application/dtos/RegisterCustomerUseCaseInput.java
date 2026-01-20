package com.example.client.application.dtos;

public record RegisterCustomerUseCaseInput(
        String name,
        String email,
        String city,
        String gender
) {
}
