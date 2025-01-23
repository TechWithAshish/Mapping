package com.example.mapping.Entity.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@ToString
public class CurrentAccount{
    @Id
    public int currentAccountId;
    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    @JsonIgnore
    public Account account;
    public double interestRate;
}
