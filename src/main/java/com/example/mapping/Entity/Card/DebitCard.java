package com.example.mapping.Entity.Card;

import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Enum.CardSubType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DebitCard{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int debitCard;
    public String name;
    public CardSubType cardSubType;
    public LocalDate expiryDate;
    @OneToOne
    @JoinColumn(name = "account_Id")
    public Account account;
}
