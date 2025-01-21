package com.example.mapping.Entity.Card;

public class CardFactory {
    public static Card getCard(CardType cardType){
        if(cardType == null){
            return null;
        }
        return switch (cardType){
            case DEBIT ->  new CreditCard();
            case CREDIT -> new DebitCard();
            default -> null;
        };
    }
}
