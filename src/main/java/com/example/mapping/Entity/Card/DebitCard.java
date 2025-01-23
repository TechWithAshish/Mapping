package com.example.mapping.Entity.Card;

import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Enum.CardSubType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DebitCard{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int debitCardId;
    public String name;
    public String cardSubType;
    public LocalDate expiryDate;
    @OneToOne
    @JoinColumn(name = "account_Id")
    @JsonIgnore
    public Account account;
}
