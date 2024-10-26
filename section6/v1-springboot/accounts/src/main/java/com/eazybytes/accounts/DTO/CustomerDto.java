package com.eazybytes.accounts.DTO;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "name cannot be empty")
    @Size(min=0,max = 30,message = "the length of name should be between 0 and 30")
    private String name;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    @Digits(fraction = 0, integer = 10, message = "Please provide a valid mobile number")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
