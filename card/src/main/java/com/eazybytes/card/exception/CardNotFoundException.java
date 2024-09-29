package com.eazybytes.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String resrouceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : '%s'",resrouceName,fieldName,fieldValue));
    }
}
