package com.example.mapping.DTO;

import com.example.mapping.Enum.TransactionType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransactionDto {
    public TransactionType transactionType;
    public double amount;
    public int accountId;
}
