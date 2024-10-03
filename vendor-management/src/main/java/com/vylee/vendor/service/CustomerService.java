package com.vylee.vendor.service;

import java.util.List;

import com.vylee.vendor.model.Customer;

public interface CustomerService {
	Customer registerCustomer(Customer customer);
	Customer getCustomerDetails(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
}
