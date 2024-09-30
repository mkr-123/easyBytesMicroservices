package com.eazybytes.card.service.impl;

import com.eazybytes.card.DTO.CardDto;
import com.eazybytes.card.entity.Cards;
import com.eazybytes.card.exception.ResrouceNotFoundException;
import com.eazybytes.card.mapper.CardMapper;
import com.eazybytes.card.repoistory.CardRepo;
import com.eazybytes.card.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {
    private CardRepo cardsRepository;
    @Override
    public void createCard(CardDto cardDto) {
        cardsRepository.save(CardMapper.mapToCard(cardDto));
    }

    @Override
    public CardDto fetchCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResrouceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardMapper.mapToCardDto(cards);
    }
}
