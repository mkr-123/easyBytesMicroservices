package com.eazybytes.accounts.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepoistory extends JpaRepository<com.eazybytes.accounts.entity.Customer,Long> {
}
