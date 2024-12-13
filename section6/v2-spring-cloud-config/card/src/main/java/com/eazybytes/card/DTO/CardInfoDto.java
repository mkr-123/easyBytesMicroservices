package com.eazybytes.card.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "card")
@Getter @Setter
public class CardInfoDto{
   private String message;
   private Map<String,String> contactDetails;
   private List<String> onCallSupport;
}
