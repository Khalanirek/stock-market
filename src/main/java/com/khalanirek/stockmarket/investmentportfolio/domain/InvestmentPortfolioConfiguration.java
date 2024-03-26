package com.khalanirek.stockmarket.investmentportfolio.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class InvestmentPortfolioConfiguration {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final InvestmentPortfolioRepository investmentPortfolioRepository;

    @Bean
    InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade() {
        return new InvestmentPortfolioCommandFacade(applicationEventPublisher, investmentPortfolioRepository);
    }

    @Bean
    InvestmentPortfolioQueryFacade investmentPortfolioQueryFacade() {
        return new InvestmentPortfolioQueryFacade(investmentPortfolioRepository);
    }

}
