package com.example.mapping.DTO;

import com.example.mapping.Enum.CardType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DebitCardDto {
    public CardType cardType;
    public String name;
    public int accountId;
}
