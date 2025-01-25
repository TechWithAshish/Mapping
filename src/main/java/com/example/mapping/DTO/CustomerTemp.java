package com.example.mapping.DTO;

import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Entity.Card.CreditCard;
import com.example.mapping.Entity.Customer.Address;
import com.example.mapping.Entity.Loan.LoanAccount;
import com.example.mapping.Entity.Locker.Locker;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerTemp {
    public int customerId;
    public String name;
    public String mobileNumber;
    public String email;

    List<Address> addresses = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();
    List<CreditCard> creditCards = new ArrayList<>();
    List<LoanAccount> loanAccounts = new ArrayList<>();
    Set<Locker> lockerList = new HashSet<>();


}
