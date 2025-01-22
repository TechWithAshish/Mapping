package com.example.mapping.Entity.Loan;

import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Entity.Transaction.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanAccount{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int loanAccountId;
    public long loanAmount;
    public boolean isActive;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;
}
