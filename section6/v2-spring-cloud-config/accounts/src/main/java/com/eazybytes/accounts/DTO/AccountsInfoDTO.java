package com.eazybytes.accounts.DTO;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
public record AccountsInfoDTO(String message, Map<String,String> contactDetails, List<String> onCallSupport) {
}
