package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class InvestorConfiguration {

    private final InvestorRepository investorRepository;
    private final AccountCommandFacade accountCommandFacade;

    @Bean
    InvestorCommandFacade investorCommandFacade() {
        return new InvestorCommandFacade(investorRepository, accountCommandFacade);
    }

    @Bean
    InvestorQueryFacade investorQueryFacade() {
        return new InvestorQueryFacade(investorRepository);
    }

}
