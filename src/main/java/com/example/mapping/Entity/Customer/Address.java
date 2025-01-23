package com.example.mapping.Entity.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String address;
    @ManyToOne
    @JoinColumn(name = "customer_Id")
    @JsonIgnore
    public Customer customer;

}
