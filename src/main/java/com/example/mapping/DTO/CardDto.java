package com.example.mapping.DTO;

import com.example.mapping.Enum.CardType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CardDto {
    public CardType cardType;
    public String name;
    public int customerId;
    public int accountId;
}
