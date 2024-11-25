package com.eazybytes.card.service.impl;

import com.eazybytes.card.DTO.CardDto;
import com.eazybytes.card.constants.CardsConstants;
import com.eazybytes.card.entity.Cards;
import com.eazybytes.card.exception.CardAlreadyExistsException;
import com.eazybytes.card.exception.ResrouceNotFoundException;
import com.eazybytes.card.mapper.CardMapper;
import com.eazybytes.card.repoistory.CardRepo;
import com.eazybytes.card.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {
    private CardRepo cardsRepository;
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCards = cardsRepository.findByMobileNumber(mobileNumber);
        if (optionalCards.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber " + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

        @Override
    public CardDto fetchCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResrouceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardMapper.mapToCardDto(cards,new CardDto());
    }

    @Override
    public boolean updateCard(CardDto cardDto) {
        Cards cards = cardsRepository.findByCardNumber(cardDto.getCardNumber()).orElseThrow(
                () -> new ResrouceNotFoundException("Card", "CardNumber", cardDto.getCardNumber())
        );
        CardMapper.mapToCard(cardDto, cards);
        cardsRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResrouceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
      cardsRepository.delete(cards);
        return true;
    }
}
