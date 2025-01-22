package com.example.mapping.Entity.Account;

import com.example.mapping.Entity.Transaction.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JointAccount{
    @Id
    public int accountId;
    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    public Account account;
    public double interestRate;
}
