package com.khalanirek.stockmarket.investor.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class InvestorConfiguration {

    private final InvestorRepository investorRepository;

    @Bean
    InvestorCommandFacade investorCommandFacade() {
        return new InvestorCommandFacade(investorRepository);
    }

    @Bean
    InvestorQueryFacade investorQueryFacade() {
        return new InvestorQueryFacade(investorRepository);
    }

}
