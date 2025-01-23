package com.example.mapping.Service;

import com.example.mapping.DTO.AccountDto;
import com.example.mapping.Entity.Account.Account;

public interface AccountService {
    public Account createAccount(AccountDto account);
    public Account getAccountById(int accountId);
    public void deleteAccount(int accountId);
    public Account updateAccount(Account account);
}
