package com.khalanirek.stockmarket.communication.infrastructure;

import com.khalanirek.stockmarket.account.dto.AccountEventsDto;
import com.khalanirek.stockmarket.company.dto.CompanyEventsDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioEventsDto;
import com.khalanirek.stockmarket.investor.dto.InvestorEventsDto;
import com.khalanirek.stockmarket.order.dto.OrderEventsDto;

public interface KafkaPublisherClient {

    void publishEvent(AccountEventsDto.AccountEvent event);

    void publishEvent(CompanyEventsDto.CompanyEvent event);

    void publishEvent(InvestmentPortfolioEventsDto.InvestmentPortfolioEvent event);

    void publishEvent(InvestorEventsDto.InvestorEvent event);

    void publishEvent(OrderEventsDto.OrderEvent event);

}
