package com.example.mapping.Entity.Customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String address;
    @ManyToOne
    @JoinColumn(name = "customer_Id")
    public Customer customer;

}
