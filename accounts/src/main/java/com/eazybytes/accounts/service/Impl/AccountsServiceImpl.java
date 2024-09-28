package com.eazybytes.accounts.service.Impl;

import com.eazybytes.accounts.DTO.AccountsDto;
import com.eazybytes.accounts.DTO.CustomerDto;
import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyExistsException;
import com.eazybytes.accounts.exception.ResrouceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
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

    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
     Customer customer=   customerRepoistory.findByMobileNumber(mobileNumber)
             .orElseThrow(()->new ResrouceNotFoundException("Customer","mobileNumber",mobileNumber));

     Accounts account=accountsRepoistory.findByCustomerId(customer.getCustomerId())
             .orElseThrow(()->new ResrouceNotFoundException("Account","CustomerId",customer.getCustomerId().toString()));
    CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account,new AccountsDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDTO) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDTO.getAccountsDto();
        if(accountsDto !=null ){
            Accounts accounts = accountsRepoistory.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResrouceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepoistory.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepoistory.findById(customerId).orElseThrow(
                    () -> new ResrouceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDTO,customer);
            customerRepoistory.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
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
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepoistory.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResrouceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountsRepoistory.deleteByCustomerId(customer.getCustomerId());
        customerRepoistory.deleteById(customer.getCustomerId());
        return true;
    }
}
