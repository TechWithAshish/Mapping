package com.example.mapping.Entity.Loan;

import com.example.mapping.Entity.Customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoanAccount{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int loanAccountId;
    public long loanAmount;
    public boolean active;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    public Customer customer;
}
