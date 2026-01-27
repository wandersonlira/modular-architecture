package com.example.client.presentation.dtos;

public record RegisterCustomerRequestDTO(
        String name,
        String email,
        String city,
        String gender
) {
}
