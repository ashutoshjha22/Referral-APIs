package com.vylee.vendor.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vylee.vendor.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerEmail(String email);

}
