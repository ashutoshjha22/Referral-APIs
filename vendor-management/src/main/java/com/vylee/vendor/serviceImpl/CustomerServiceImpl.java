package com.vylee.vendor.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vylee.vendor.model.Customer;
import com.vylee.vendor.repo.CustomerRepository;
import com.vylee.vendor.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {
    	customer.setPassword(new BCryptPasswordEncoder().encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    @Override
    public  Customer getCustomerDetails(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
    	Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
    	customerRepository.deleteById(id);
    }

	
}
