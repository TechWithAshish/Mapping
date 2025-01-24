package com.example.mapping.Service;

import com.example.mapping.DTO.AccountDto;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Entity.Loan.LoanAccount;
import com.example.mapping.Repository.LoanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanAccountServiceImpl implements LoanAccountService{

    @Autowired
    private LoanAccountRepository loanAccountRepository;
    @Autowired
    private CustomerService customerService;


    @Override
    public LoanAccount createLoanAccount(AccountDto account) {
        Customer customerById = customerService.getCustomerById(account.getCustomerId());
        LoanAccount loanAccount = new LoanAccount();
        loanAccount.setLoanAmount(account.getBalance());
        loanAccount.setActive(true);
        loanAccount.setCustomer(customerById);
        customerById.getLoanAccounts().add(loanAccount);
        return loanAccountRepository.save(loanAccount);
    }

    @Override
    public LoanAccount getLoanAccount(int id) {
        return loanAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("No Loan account found"));
    }

    @Override
    public void deleteAccount(int id) {
        loanAccountRepository.deleteById(id);
    }

    @Override
    public LoanAccount updateLoanAccount(LoanAccount account) {
        return loanAccountRepository.save(account);
    }
}
