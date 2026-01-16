package com.example.client.domain.domain_services;

import com.example.client.domain.entities.Customer;
import com.example.client.domain.value_objects.StatusCustomer;

public class VerifyActivity {
    public void isActiveForOrder(Customer customer) {
        if (customer.getStatusCustomer().equals(StatusCustomer.INACTIVE)) {
            throw new IllegalArgumentException("Inactive customers cannot place new orders.");
        }
    }
}
