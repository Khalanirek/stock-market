package com.khalanirek.stockmarket.account.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class AccountConfiguration {

    private final AccountRepository accountRepository;
    @Bean
    AccountCommandFacade accountCommandFacade() {
        return new AccountCommandFacade(accountRepository);
    }

    @Bean
    AccountQueryFacade accountQueryFacade() {
        return new AccountQueryFacade(accountRepository);
    }

}
