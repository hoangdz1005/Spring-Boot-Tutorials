package com.springboot.OneToMany.controller;

import com.springboot.OneToMany.model.Customer;
import com.springboot.OneToMany.model.Order;
import com.springboot.OneToMany.repository.CustomerRepository;
import com.springboot.OneToMany.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getAllOrders(@PathVariable Long id) {
        return ResponseEntity.ok(orderRepository.findById(id));
    }
    @PostMapping("/orders")
    public ResponseEntity<?> createOrders(@RequestParam(name = "customerId") Long customerId , @RequestBody Order order) {
        Customer customer = customerRepository.findById(customerId).get();
        order.setCustomer(customer);
        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }
}
