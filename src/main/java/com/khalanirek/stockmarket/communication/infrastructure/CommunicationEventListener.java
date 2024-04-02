package com.khalanirek.stockmarket.communication.infrastructure;

import com.khalanirek.stockmarket.account.dto.AccountEventsDto;
import com.khalanirek.stockmarket.company.dto.CompanyEventsDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioEventsDto;
import com.khalanirek.stockmarket.investor.dto.InvestorEventsDto;
import com.khalanirek.stockmarket.order.dto.OrderEventsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
public class CommunicationEventListener {

    private final KafkaPublisherClient kafkaPublisher;
    @TransactionalEventListener
    public void onAccountEvent(AccountEventsDto.AccountEvent event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onCompanyEvent(CompanyEventsDto.CompanyEvent event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onInvestmentPortfolioEvent(InvestmentPortfolioEventsDto.InvestmentPortfolioEvent event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onInvestorEvent(InvestorEventsDto.InvestorEvent event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onOrderEvent(OrderEventsDto.OrderEvent event) {
        kafkaPublisher.publishEvent(event);
    }

}
