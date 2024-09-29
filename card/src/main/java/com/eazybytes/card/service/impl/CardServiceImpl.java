package com.eazybytes.card.service.impl;

import com.eazybytes.card.DTO.CardDto;
import com.eazybytes.card.mapper.CardMapper;
import com.eazybytes.card.repoistory.CardRepo;
import com.eazybytes.card.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {
    private CardRepo cardRepo;
    @Override
    public void createCard(CardDto cardDto) {
        cardRepo.save(CardMapper.mapToCard(cardDto));
    }
}
