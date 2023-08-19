package com.springboot.OneToOne.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Long id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer(String name) {
        this.name = name;
    }
}
