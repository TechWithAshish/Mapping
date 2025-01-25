package com.example.mapping.Entity.Locker;

import com.example.mapping.Entity.Customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"customerList"})
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int lockerId;
    // one locker can have multiple customer so there will be N:M mapping

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "customer_Locker",
            joinColumns = @JoinColumn(name = "locker_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    Set<Customer> customerList = new HashSet<>();
}
