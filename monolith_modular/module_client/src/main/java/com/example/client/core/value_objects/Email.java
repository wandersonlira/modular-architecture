package com.example.client.domain.value_objects;

import java.util.Objects;

public final class Email {
    private final String email;



    public Email(String email) {
        this.valid(email);
        this.email = email;
    }


    private void valid(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required.");
        }
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(regex)) {
            throw new IllegalArgumentException("Email invalid");
        }
    }


    public String getEmail() {
        return email;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

}