package com.example.client.domain.entities;

import com.example.client.domain.value_objects.Email;
import com.example.client.domain.value_objects.Gender;
import com.example.client.domain.value_objects.StatusCustomer;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

public class Customer extends Person {
    private String city;
    private Email email;
    private BigDecimal discount;
    private StatusCustomer statusCustomer;


    public Customer(String name, Gender sex, Email email, String city) {
        super(name, sex);
//        emailValid(email);
        validateCity(city);
        this.email = email;
        this.city = city;
        this.statusCustomer = StatusCustomer.INACTIVE;
    }

//  Foi substituido pelo Value Objects (Email)
//    private void emailValid(Email email) {
//        if (email == null || email.trim().isEmpty()) {
//            throw new IllegalArgumentException("Email is required.");
//        }
//
//        String regexEmail = "^[^@]+@[^@]+\\.[^@]+$";
//        if (!Pattern.matches(regexEmail, email)) {
//            throw new IllegalArgumentException("Invalid email.");
//        }
//
//    }

    private void validateCity(String city) {
        if (city == null || city.trim().isBlank()) {
            throw new IllegalArgumentException("City is required");
        }
    }

    public void activateCustomer() {
        if (this.getName() == null || this.getName().trim().isBlank()
                || this.getSex() == null || this.getSex().name().isBlank()
                || this.city == null || this.city.isBlank() ) {
            throw new IllegalArgumentException("Customer with incomplete registration.");
        }
        this.statusCustomer = StatusCustomer.ACTIVE;
    }

    public void inactive() {
        this.statusCustomer = StatusCustomer.INACTIVE;
    }

    public void changeCity(String newCity) {
        validateCity(newCity);
        this.city = newCity;
    }


    public String getCity() { return city; }
    public StatusCustomer getStatusCustomer() { return statusCustomer; }
    public String getEmail() { return this.email.getEmail(); }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer client = (Customer) o;
        return Objects.equals(city, client.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city);
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + this.getName() + '\'' +
                ", sex=" + this.getSex() +
                ", city='" + city + '\'' +
                ", email=" + email.getEmail() +
                ", statusCustomer=" + statusCustomer +
                '}';
    }

    public static void main(String[] args) {
        Email email = new Email("wandersonlira@mv.com.br");
        Customer customer = new Customer("Wanderson", Gender.MAN, email, "Recife");
        System.out.println("AAAAA: " + customer.toString());
    }

}

