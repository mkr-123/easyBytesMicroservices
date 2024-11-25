package com.eazybytes.accounts.repoistory;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepoistory extends JpaRepository<com.eazybytes.accounts.entity.Customer,Long> {
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
