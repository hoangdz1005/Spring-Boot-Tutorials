package com.springboot.OneToOne.controller;

import com.springboot.OneToOne.model.Address;
import com.springboot.OneToOne.model.Customer;
import com.springboot.OneToOne.repository.AddressRepository;
import com.springboot.OneToOne.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).get();
        return ResponseEntity.ok(customer);
    }
    @PostMapping("/customer/{id}")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerRequest, @PathVariable Long id) {
        Address address = addressRepository.findById(id).get();
        customerRequest.setAddress(address);
        customerRepository.save(customerRequest);
        return ResponseEntity.ok(customerRequest);
    }
}
