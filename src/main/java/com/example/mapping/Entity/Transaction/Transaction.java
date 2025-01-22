package com.example.mapping.Entity.Transaction;

import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Enum.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int transactionId;
    public TransactionType type;
    public long amount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    public Account account;
}
