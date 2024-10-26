package com.eazybytes.card.mapper;

import com.eazybytes.card.DTO.CardDto;
import com.eazybytes.card.entity.Cards;

public class CardMapper {

    public static CardDto mapToCardDto(Cards card,CardDto cardDto) {

        cardDto.setCardType(card.getCardType());
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setAmountUsed(card.getAmountUsed());
        cardDto.setAvailableAmount(card.getAvailableAmount());
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setMobileNumber(card.getMobileNumber());
        return cardDto;
    }

    public static Cards mapToCard(CardDto cardDto,Cards card) {

        card.setCardType(cardDto.getCardType());
        card.setCardNumber(cardDto.getCardNumber());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setAvailableAmount(cardDto.getAvailableAmount());
        card.setCardNumber(cardDto.getCardNumber());
        card.setMobileNumber(cardDto.getMobileNumber());
        return card;
    }
}
