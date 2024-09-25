package com.eazybytes.accounts.service.Impl;

import com.eazybytes.accounts.DTO.CustomerDto;
import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyExistsException;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repoistory.AccountsRepoistory;
import com.eazybytes.accounts.repoistory.CustomerRepoistory;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepoistory accountsRepoistory;
    private CustomerRepoistory customerRepoistory;
    @Override
    public void createAccount(CustomerDto customerDTO) {
    Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
    Optional<Customer> optionaClass=customerRepoistory.findByMobileNumber(customerDTO.getMobileNumber());
   if(optionaClass.isPresent()){
       throw  new CustomerAlreadyExistsException("Customer already registered with given number "+customerDTO.getMobileNumber());
   }
   customer.setCreatedAt(LocalDateTime.now());
   customer.setCreatedBy("Anamyous");
    Customer savedCustomer = customerRepoistory.save(customer);
        accountsRepoistory.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anamyous");
        return newAccount;
    }
}
