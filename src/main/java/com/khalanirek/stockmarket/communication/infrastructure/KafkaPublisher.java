package com.khalanirek.stockmarket.communication.infrastructure;

import com.khalanirek.stockmarket.account.dto.AccountEventsDto;
import com.khalanirek.stockmarket.company.dto.CompanyEventsDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioEventsDto;
import com.khalanirek.stockmarket.investor.dto.InvestorEventsDto;
import com.khalanirek.stockmarket.order.dto.OrderEventsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

import static com.khalanirek.stockmarket.infrastructure.KafkaConfiguration.Topics.*;

@RequiredArgsConstructor
class KafkaPublisher implements KafkaPublisherClient {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishEvent(AccountEventsDto.AccountEvent event) {
        kafkaTemplate.send(ACCOUNTS, "Account event published");
    }

    @Override
    public void publishEvent(CompanyEventsDto.CompanyEvent event) {
        kafkaTemplate.send(COMPANIES, "Company event published");
    }

    @Override
    public void publishEvent(InvestmentPortfolioEventsDto.InvestmentPortfolioEvent event) {
        kafkaTemplate.send(INVESTMENT_PORTFOLIOS, "InvestmentPortfolio event published");
    }

    @Override
    public void publishEvent(InvestorEventsDto.InvestorEvent event) {
        kafkaTemplate.send(INVESTORS, "Investor event published");
    }

    @Override
    public void publishEvent(OrderEventsDto.OrderEvent event) {
        kafkaTemplate.send(ORDERS, "Order event published");
    }

}
