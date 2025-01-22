package com.example.mapping.Entity.Locker;

import com.example.mapping.Entity.Customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Locker {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public int lockerId;
    // one locker can have multiple customer so there will be N:M mapping

//    @ManyToMany
//    @JoinTable(
//            name = "customer_Locker",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "")
//
//    )
    List<Customer> customerList = new ArrayList<>();
}
