package com.eazybytes.accounts.repoistory;

import com.eazybytes.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepoistory extends JpaRepository<Accounts, Long> {

}
