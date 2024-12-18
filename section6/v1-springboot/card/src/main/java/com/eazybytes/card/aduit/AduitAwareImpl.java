package com.eazybytes.card.aduit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AduitAwareImpl implements AuditorAware<String>{

    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of("Cards_MS");
    }
}
