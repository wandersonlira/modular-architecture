package com.example.client.application.dtos;

public record RegisterCustomerUseCaseOutput(
        String name,
        String email,
        String city,
        String gender,
        String status
) {
}
