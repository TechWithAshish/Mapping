package com.example.mapping.Service;

import com.example.mapping.DTO.TransactionDto;
import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Entity.Transaction.Transaction;
import com.example.mapping.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;

    @Override
    public Transaction createTransaction(TransactionDto transactionDto) {
        Account accountById = accountService.getAccountById(transactionDto.getAccountId());
        Transaction transaction = new Transaction();
        transaction.setAccount(accountById);
        transaction.setAmount(100);
        transaction.setType(transactionDto.getTransactionType().toString());
        // let me add transaction to my list of account
        accountById.getTransactionList().add(transaction);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransaction(int id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("No transaction found"));
    }
}
