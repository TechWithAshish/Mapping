package com.example.mapping.Service;

import com.example.mapping.DTO.CardDto;
import com.example.mapping.Entity.Card.CreditCard;

public interface CreditCardService {
    public CreditCard createCreditCard(CardDto cardDto);
    public CreditCard getCreditCard(int id);
    public void deleteCreditCard(int id);
}
