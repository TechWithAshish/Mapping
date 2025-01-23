package com.example.mapping.Entity.Account;


import com.example.mapping.Entity.Card.DebitCard;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Entity.Transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int accountId;
    public int balance;
    public boolean isActive;
    @ManyToOne
    @JoinColumn(name = "customer_Id")
    @JsonIgnore
    public Customer customer;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    public List<Transaction> transactionList = new ArrayList<>();
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, optional = true)
    public SavingAccount savingAccount;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, optional = true)
    public CurrentAccount currentAccount;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, optional = true)
    public JointAccount jointAccount;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    public DebitCard debitCard;
}
