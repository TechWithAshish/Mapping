package com.example.mapping.Service;

import com.example.mapping.DTO.CardDto;
import com.example.mapping.DTO.DebitCardDto;
import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Entity.Card.DebitCard;
import com.example.mapping.Entity.Card.RandomCardType;
import com.example.mapping.Repository.AccountRepository;
import com.example.mapping.Repository.DebitCardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class DebitCardServiceImpl implements DebitCardService{

    @Autowired
    private DebitCardRepository debitCardRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public DebitCard createDebitCard(CardDto cardDto) {
        Account accountById = accountService.getAccountById(cardDto.getAccountId());
        DebitCard debitCard = new DebitCard();
        debitCard.setName(cardDto.getName());
        debitCard.setCardSubType(RandomCardType.randomSelectionOfCard().toString());
        debitCard.setExpiryDate(LocalDate.now().plusYears(4)
                .plusMonths(2)
                .plusDays(10));
        debitCard.setAccount(accountById);
        // let set debit card for account
        if(accountById.getDebitCard() != null){
            // then first need to delete earlier debit card
            // need to maintain 1-1 mapping
            deleteDebitCard(accountById.getDebitCard().getDebitCardId());
        }
        accountById.setDebitCard(debitCard);
        return debitCardRepository.save(debitCard);
    }

    @Override
    public DebitCard getDebitCardById(int id) {
        return debitCardRepository.findById(id).orElseThrow(() -> new RuntimeException("No Debit Card found"));
    }

    @Override
    public void deleteDebitCard(int id) {
        log.info("Inside debit card delete method");
        DebitCard debitCard = getDebitCardById(id);
        Account account = debitCard.getAccount();
        account.setDebitCard(null);
        accountRepository.save(account);
        debitCardRepository.deleteById(id);
    }
}
