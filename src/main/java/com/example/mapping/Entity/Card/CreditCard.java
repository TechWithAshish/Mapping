package com.example.mapping.Entity.Card;

import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Enum.CardSubType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class CreditCard{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int creditCardId;
    public CardSubType cardSubType;
    public String name;
    public LocalDate expiryDate;
    // customer mapping will be there....
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    public Customer customer;
}
