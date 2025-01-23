package com.example.mapping.Service;

import com.example.mapping.Entity.Loan.LoanAccount;

public interface LoanAccountService {
    public LoanAccount createLoanAccount(LoanAccount account);
    public LoanAccount getLoanAccount(int id);
    public void deleteAccount(int id);
    public LoanAccount updateLoanAccount(LoanAccount account);
}
