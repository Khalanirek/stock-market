package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade;
import com.khalanirek.stockmarket.investmentportfolio.domain.InvestmentPortfolioCommandFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class InvestorConfiguration {

    private final InvestorRepository investorRepository;
    private final AccountCommandFacade accountCommandFacade;
    private final InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade;

    @Bean
    InvestorCommandFacade investorCommandFacade() {
        return new InvestorCommandFacade(investorRepository, accountCommandFacade, investmentPortfolioCommandFacade);
    }

    @Bean
    InvestorQueryFacade investorQueryFacade() {
        return new InvestorQueryFacade(investorRepository);
    }

}
