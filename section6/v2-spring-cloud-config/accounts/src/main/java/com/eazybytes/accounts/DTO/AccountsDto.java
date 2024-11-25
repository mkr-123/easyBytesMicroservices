package com.eazybytes.accounts.DTO;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @NotEmpty(message="account type cannot be empty")
    private String accountType;
    @NotEmpty(message="branch address cannot be empty")
    private String branchAddress;
    @NotEmpty(message="account number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "account number should be 10 digits long")
    private Long accountNumber;
}
