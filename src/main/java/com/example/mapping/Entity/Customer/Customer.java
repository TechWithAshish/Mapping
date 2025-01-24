package com.example.mapping.Entity.Customer;

import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Entity.Account.CurrentAccount;
import com.example.mapping.Entity.Account.JointAccount;
import com.example.mapping.Entity.Account.SavingAccount;
import com.example.mapping.Entity.Card.CreditCard;
import com.example.mapping.Entity.Loan.LoanAccount;
import com.example.mapping.Entity.Locker.Locker;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int customerId;
    public String name;
    public String mobileNumber;
    public String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Address> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Account> accounts = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<CreditCard> creditCards = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<LoanAccount> loanAccounts = new ArrayList<>();
    @ManyToMany(mappedBy = "customerList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set<Locker> lockerList = new HashSet<>();
}
