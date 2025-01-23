package com.example.mapping.Service;

import com.example.mapping.DTO.CardDto;
import com.example.mapping.DTO.DebitCardDto;
import com.example.mapping.Entity.Account.Account;
import com.example.mapping.Entity.Card.DebitCard;
import com.example.mapping.Entity.Card.RandomCardType;
import com.example.mapping.Repository.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DebitCardServiceImpl implements DebitCardService{

    @Autowired
    private DebitCardRepository debitCardRepository;
    @Autowired
    private AccountService accountService;

    @Override
    public DebitCard createDebitCard(CardDto cardDto) {
        Account accountById = accountService.getAccountById(cardDto.getAccountId());
        DebitCard debitCard = new DebitCard();
        debitCard.setName(cardDto.getName());
        debitCard.setCardSubType(RandomCardType.randomSelectionOfCard());
        debitCard.setExpiryDate(LocalDate.now().plusYears(4)
                .plusMonths(2)
                .plusDays(10));
        debitCard.setAccount(accountById);
        // let set debit card for account
        accountById.setDebitCard(debitCard);
        return debitCardRepository.save(debitCard);
    }

    @Override
    public DebitCard getDebitCardById(int id) {
        return debitCardRepository.findById(id).orElseThrow(() -> new RuntimeException("No Debit Card found"));
    }

    @Override
    public void deleteDebitCard(int id) {
        debitCardRepository.deleteById(id);
    }
}
