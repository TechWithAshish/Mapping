package com.example.mapping.Service;

import com.example.mapping.DTO.CardDto;
import com.example.mapping.DTO.DebitCardDto;
import com.example.mapping.Entity.Card.DebitCard;

public interface DebitCardService {
    public DebitCard createDebitCard(CardDto debitCardDto);
    public DebitCard getDebitCardById(int id);
    public void deleteDebitCard(int id);
    // we can't have debit card for it....

}
