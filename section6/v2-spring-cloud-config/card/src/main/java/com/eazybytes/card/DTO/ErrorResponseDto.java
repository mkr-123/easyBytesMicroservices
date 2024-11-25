package com.eazybytes.card.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
public class ErrorResponseDto {

   private String aiPath;
   private HttpStatus errorCode;
   private String message;
   private LocalDateTime errorTime;
}
