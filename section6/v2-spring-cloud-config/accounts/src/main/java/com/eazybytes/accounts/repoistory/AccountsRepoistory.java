package com.eazybytes.accounts.repoistory;

import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepoistory extends JpaRepository<Accounts, Long> {




    Optional<Accounts> findByCustomerId(Long customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
