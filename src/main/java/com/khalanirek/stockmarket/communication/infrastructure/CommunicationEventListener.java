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
    public void onAccountCreatedEvent(AccountEventsDto.AccountCreated event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onFundsBlockedEvent(AccountEventsDto.FundsBlocked event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onFundsDepositedEvent(AccountEventsDto.FundsDeposited event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onFundsWithdrewEvent(AccountEventsDto.FundsWithdrew event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onCompanyEvent(CompanyEventsDto.CompanyRegisteredEvent event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onInvestmentPortfolioEvent(InvestmentPortfolioEventsDto.InvestmentPortfolioCreated event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onInvestmentPortfolioEvent(InvestmentPortfolioEventsDto.ShareAdded event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onInvestmentPortfolioEvent(InvestmentPortfolioEventsDto.ShareBlocked event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onInvestorEvent(InvestorEventsDto.InvestorRegisteredEvent event) {
        kafkaPublisher.publishEvent(event);
    }

    @TransactionalEventListener
    public void onOrderEvent(OrderEventsDto.OrderSubmittedEvent event) {
        kafkaPublisher.publishEvent(event);
    }

}
