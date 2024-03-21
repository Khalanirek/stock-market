package com.khalanirek.stockmarket.order.domain;

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade;
import com.khalanirek.stockmarket.investmentportfolio.domain.InvestmentPortfolioCommandFacade;
import com.khalanirek.stockmarket.investor.domain.InvestorQueryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class OrderConfiguration {

    private final OrderRepository orderRepository;
    private final InvestorQueryFacade investorQueryFacade;
    private final AccountCommandFacade accountCommandFacade;
    private final InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade;

    @Bean
    OrderCommandFacade orderCommandFacade() {
        return new OrderCommandFacade(orderRepository, investorQueryFacade, accountCommandFacade, investmentPortfolioCommandFacade);
    }

    @Bean
    OrderQueryFacade orderQueryFacade() {
        return new OrderQueryFacade(orderRepository);
    }

}
