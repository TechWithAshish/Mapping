package com.example.mapping.Entity.Transaction;

import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Enum.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int transactionId;
    public String type;
    public double amount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    public Account account;
}
