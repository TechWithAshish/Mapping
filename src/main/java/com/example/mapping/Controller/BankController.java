package com.example.mapping.Controller;


import com.example.mapping.DTO.*;
import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Entity.Card.CreditCard;
import com.example.mapping.Entity.Card.DebitCard;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Entity.Loan.LoanAccount;
import com.example.mapping.Entity.Locker.Locker;
import com.example.mapping.Entity.Transaction.Transaction;
import com.example.mapping.Enum.AccountType;
import com.example.mapping.Enum.CardType;
import com.example.mapping.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private DebitCardService debitCardService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private LoanAccountService loanAccountService;
    @Autowired
    private LockerService lockerService;

    @PostMapping("/create-customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto){
        Customer customer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/create-account")
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto){
        if(accountDto.accountType == AccountType.LOAN){
            LoanAccount loanAccount = loanAccountService.createLoanAccount(accountDto);
            return new ResponseEntity<>(loanAccount, HttpStatus.CREATED);
        }else{
            Account account = accountService.createAccount(accountDto);
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        }

    }

    @PostMapping("/create-card")
    public ResponseEntity<?> createCreditCard(@RequestBody CardDto cardDto){
        if(cardDto.getCardType() == CardType.CREDIT){
            CreditCard creditCard = creditCardService.createCreditCard(cardDto);
            return new ResponseEntity<>(creditCard, HttpStatus.CREATED);
        }else{
            DebitCard debitCard = debitCardService.createDebitCard(cardDto);
            return new ResponseEntity<>(debitCard, HttpStatus.CREATED);
        }

    }

    @PostMapping("/create-transaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto transactionDto){
        Transaction transaction = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @PostMapping("/create-locker")
    public ResponseEntity<Locker> createLocker(){
        Locker locker = lockerService.createLocker();
        return new ResponseEntity<>(locker, HttpStatus.CREATED);
    }

    @GetMapping("/loan-account")
    public ResponseEntity<LoanAccount> createLoanAccount(@RequestParam("loanAccountId") int loanAccountId){
        LoanAccount loanAccount = loanAccountService.getLoanAccount(loanAccountId);
        return new ResponseEntity<>(loanAccount, HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomerById(@RequestParam("customerId") int customerId){
        Customer customerById = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerById, HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<Account> getAccountById(@RequestParam("accountId") int accountId){
        Account accountById = accountService.getAccountById(accountId);
        return new ResponseEntity<>(accountById, HttpStatus.OK);
    }

    @GetMapping("/credit-card")
    public ResponseEntity<CreditCard> getCreditCard(@RequestParam("creditCardId") int creditCardId){
        CreditCard creditCard = creditCardService.getCreditCard(creditCardId);
        return new ResponseEntity<>(creditCard, HttpStatus.OK);
    }

    @GetMapping("/debit-card")
    public ResponseEntity<DebitCard> getDebitCard(@RequestParam("debitCardId") int debitCardId){
        DebitCard debitCardById = debitCardService.getDebitCardById(debitCardId);
        return new ResponseEntity<>(debitCardById, HttpStatus.OK);
    }

    @GetMapping("/transaction")
    public ResponseEntity<Transaction> getTransaction(@RequestParam("transactionId") int transactionId){
        Transaction transaction = transactionService.getTransaction(transactionId);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping("/assign-locker")
    public ResponseEntity<Locker> assignCustomerWithLocker(@RequestBody LockerDto lockerDto){
        Locker locker = lockerService.assignLockerToCustomer(lockerDto);
        return new ResponseEntity<>(locker, HttpStatus.ACCEPTED);
    }

    @PostMapping("/withhold-locker")
    public ResponseEntity<Locker> withholdCustomerWithLocker(@RequestBody LockerDto lockerDto){
        Locker locker = lockerService.withHoldLockerToCustomer(lockerDto);
        return new ResponseEntity<>(locker, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/locker")
    public ResponseEntity<?> deleteLocker(@RequestParam("lockerId") int lockerId){
        lockerService.deleteLocker(lockerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/customer")
    public ResponseEntity<?> deleteCustomer(@RequestParam("customerId") int customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/loan-account")
    public ResponseEntity<LoanAccount> deleteLoanAccount(@RequestParam("loanAccountId") int loanAccountId){
        loanAccountService.deleteAccount(loanAccountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/account")
    public ResponseEntity<?> deleteAccount(@RequestParam("accountId") int accountId){
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/debit-card")
    public ResponseEntity<String> deleteDebitCard(@RequestParam("debitCardId") int debitCardId){
        debitCardService.deleteDebitCard(debitCardId);
        return new ResponseEntity<>("Deleted Debit Card", HttpStatus.OK);
    }

    @DeleteMapping("/credit-card")
    public ResponseEntity<String> deleteCreditCard(@RequestParam("creditCardId") int creditCardId){
        creditCardService.deleteCreditCard(creditCardId);
        return new ResponseEntity<>("Deleted Credit Card", HttpStatus.OK);
    }
}
