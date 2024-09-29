package com.eazybytes.card.repoistory;

import com.eazybytes.card.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Cards, Long> {
}
