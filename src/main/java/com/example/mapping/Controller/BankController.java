package com.example.mapping.Controller;


import com.example.mapping.DTO.AccountDto;
import com.example.mapping.DTO.CardDto;
import com.example.mapping.DTO.CustomerDto;
import com.example.mapping.DTO.DebitCardDto;
import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Entity.Card.CreditCard;
import com.example.mapping.Entity.Card.DebitCard;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Enum.CardType;
import com.example.mapping.Repository.CustomerRepository;
import com.example.mapping.Service.AccountService;
import com.example.mapping.Service.CreditCardService;
import com.example.mapping.Service.CustomerService;
import com.example.mapping.Service.DebitCardService;
import lombok.Getter;
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

    @PostMapping("/create-customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto){
        Customer customer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/create-account")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDto accountDto){
        Account account = accountService.createAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
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
}
