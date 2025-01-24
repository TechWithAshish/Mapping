package com.example.mapping.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LockerDto {
    public int customerId;
    public int lockerId;
}
