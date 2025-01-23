package com.example.mapping.Service;

import com.example.mapping.DTO.TransactionDto;
import com.example.mapping.Entity.Transaction.Transaction;

public interface TransactionService {
    public Transaction createTransaction(TransactionDto transactionDto);
    public Transaction getTransaction(int id);
}
