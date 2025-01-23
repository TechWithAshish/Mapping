package com.example.mapping.Entity.Card;

import com.example.mapping.Enum.CardSubType;

public class RandomCardType {

    public static CardSubType randomSelectionOfCard(){
        int num = (int)(Math.random() * 3) + 1;
        if(num == 1){
            return CardSubType.MASTERCARD;
        }else if(num == 2){
            return CardSubType.VISA;
        }else{
            return CardSubType.RUPAY;
        }
    }

}
