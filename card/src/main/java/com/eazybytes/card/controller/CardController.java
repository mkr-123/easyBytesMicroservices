package com.eazybytes.card.controller;

import com.eazybytes.card.DTO.CardDto;
import com.eazybytes.card.DTO.ResponseDto;
import com.eazybytes.card.service.ICardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CardController {
    private ICardService cardService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestBody CardDto cardDto) {

        cardService.createCard(cardDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("200", "Card created successfully"));

    }
}