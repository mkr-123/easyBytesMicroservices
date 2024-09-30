package com.eazybytes.card.service;

import com.eazybytes.card.DTO.CardDto;

public interface ICardService {
    void createCard(CardDto cardDto);

    CardDto fetchCard(String mobileNumber);
}
