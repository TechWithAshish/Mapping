package com.example.mapping.Service;

import com.example.mapping.DTO.AccountDto;
import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Entity.Account.CurrentAccount;
import com.example.mapping.Entity.Account.JointAccount;
import com.example.mapping.Entity.Account.SavingAccount;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Entity.Loan.LoanAccount;
import com.example.mapping.Enum.AccountType;
import com.example.mapping.Repository.AccountRepository;
import com.example.mapping.Repository.CustomerRepository;
import com.example.mapping.Repository.LoanAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    LoanAccountRepository loanAccountRepository;

    @Override
    public Account createAccount(AccountDto accountDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(accountDto.getCustomerId());
        if(optionalCustomer.isEmpty()){
            throw new RuntimeException("Customer not found");
        }
        Customer customer = optionalCustomer.get();
        List<Account> accounts = customer.getAccounts();
        Account account = new Account();
        account.setActive(true);
        account.setBalance(accountDto.getBalance());
        account.setCustomer(customer);
        if(accountDto.accountType == AccountType.SAVING){
            SavingAccount savingAccount = new SavingAccount();
            savingAccount.setInterestRate(2.5);
            savingAccount.setAccount(account);
            account.setSavingAccount(savingAccount);
        }else if(accountDto.accountType == AccountType.CURRENT){
            CurrentAccount currentAccount = new CurrentAccount();
            currentAccount.setAccount(account);
            currentAccount.setInterestRate(4.5);
            account.setCurrentAccount(currentAccount);
        }else{
            JointAccount jointAccount = new JointAccount();
            jointAccount.setAccount(account);
            jointAccount.setInterestRate(7.5);
            account.setJointAccount(jointAccount);
        }
        accounts.add(account);
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(int accountId) {
        return accountRepository.findById(accountId).orElseThrow(()->new RuntimeException("No Account found"));
    }

    @Override
    public void deleteAccount(int accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }
}
