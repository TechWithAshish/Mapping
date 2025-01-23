package com.example.mapping.DTO;

import com.example.mapping.Enum.AccountType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class AccountDto {
    public int balance;
    public AccountType accountType;
    public int customerId;
}
