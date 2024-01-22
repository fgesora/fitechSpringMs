package com.loopdfs.cardproject.config;

import com.loopdfs.cardproject.repository.account.AccountRepository;
import com.loopdfs.cardproject.repository.card.CardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardsRepositoryConfig {
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    public CardsRepositoryConfig(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    @Bean
    public CardsRepositoryConfig getCardsRepositoryConfig() {
        return this;
    }

    public CardRepository getCardRepository() {
        return cardRepository;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }
}
