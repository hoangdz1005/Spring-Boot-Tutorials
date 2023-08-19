package com.springboot.OneToOne.controller;

import com.springboot.OneToOne.model.Address;
import com.springboot.OneToOne.repository.AddressRepository;
import com.springboot.OneToOne.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;
    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok(addressRepository.findAll());
    }
    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        addressRepository.save(address);
        return ResponseEntity.ok(address);
    }
}
