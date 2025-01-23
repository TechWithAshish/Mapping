package com.example.mapping.DTO;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class CustomerDto {
    public String name;
    public String mobileNumber;
    public String email;
    // here we can define address now...
    public String permanentAddress;
    public String currentAddress;
}
