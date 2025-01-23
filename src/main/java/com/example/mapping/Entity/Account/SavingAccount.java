package com.example.mapping.Entity.Account;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class SavingAccount {
    @Id
    public int savingAccountId;
    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    @JsonIgnore
    public Account account;
    public double interestRate;
}
