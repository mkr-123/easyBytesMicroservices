package com.eazybytes.accounts.service.Impl;

import com.eazybytes.accounts.DTO.CustomerDto;
import com.eazybytes.accounts.repoistory.AccountsRepoistory;
import com.eazybytes.accounts.repoistory.CustomerRepoistory;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepoistory accountsRepoistory;
    private CustomerRepoistory customerRepoistory;
    @Override
    public void createAccount(CustomerDto customerDTO) {

    }
}
