package com.khalanirek.stockmarket.account.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class AccountConfiguration {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final AccountRepository accountRepository;
    @Bean
    AccountCommandFacade accountCommandFacade() {
        return new AccountCommandFacade(applicationEventPublisher, accountRepository);
    }

    @Bean
    AccountQueryFacade accountQueryFacade() {
        return new AccountQueryFacade(accountRepository);
    }

}
