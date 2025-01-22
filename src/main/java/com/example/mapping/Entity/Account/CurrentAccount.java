package com.example.mapping.Entity.Account;

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
public class CurrentAccount{
    @Id
    public int currentAccountId;
    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    public Account account;
    public double interestRate;
}
