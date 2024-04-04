package com.khalanirek.stockmarket.communication.infrastructure;

import com.khalanirek.stockmarket.account.dto.AccountEventsDto;
import com.khalanirek.stockmarket.company.dto.CompanyEventsDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioEventsDto;
import com.khalanirek.stockmarket.investor.dto.InvestorEventsDto;
import com.khalanirek.stockmarket.order.dto.OrderEventsDto;

public interface KafkaPublisherClient {

    void publishEvent(AccountEventsDto.AccountCreated event);

    void publishEvent(AccountEventsDto.FundsBlocked event);

    void publishEvent(AccountEventsDto.FundsDeposited event);

    void publishEvent(AccountEventsDto.FundsWithdrew event);

    void publishEvent(CompanyEventsDto.CompanyRegisteredEvent event);

    void publishEvent(InvestmentPortfolioEventsDto.InvestmentPortfolioCreated event);

    void publishEvent(InvestmentPortfolioEventsDto.ShareAdded event);

    void publishEvent(InvestmentPortfolioEventsDto.ShareBlocked event);

    void publishEvent(InvestorEventsDto.InvestorRegisteredEvent event);

    void publishEvent(OrderEventsDto.OrderSubmittedEvent event);

}
