package com.springboot.OneToMany.controller;

import com.springboot.OneToMany.model.Customer;
import com.springboot.OneToMany.repository.CustomerRepository;
import com.springboot.OneToMany.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }
    @PostMapping("/customers")
    public ResponseEntity<?> createCustomers(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.ok(customer);
    }
}
