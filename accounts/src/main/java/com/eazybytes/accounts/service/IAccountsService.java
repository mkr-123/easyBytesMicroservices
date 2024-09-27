package com.eazybytes.accounts.service;

import com.eazybytes.accounts.DTO.CustomerDto;

public interface IAccountsService {
    void createAccount(CustomerDto customerDTO);

    CustomerDto fetchAccountDetails(String mobileNumber);

    boolean updateAccount(CustomerDto customerDTO);
}
