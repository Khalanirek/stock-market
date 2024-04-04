package com.khalanirek.stockmarket.communication.infrastructure;

import com.khalanirek.stockmarket.account.dto.AccountEventsDto;
import com.khalanirek.stockmarket.avro.account.AccountCreatedEvent;
import com.khalanirek.stockmarket.avro.account.FundsBlockedEvent;
import com.khalanirek.stockmarket.avro.account.FundsDepositedEvent;
import com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent;
import com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent;
import com.khalanirek.stockmarket.avro.investmentportfolio.InvestmentPortfolioCreatedEvent;
import com.khalanirek.stockmarket.avro.investmentportfolio.ShareAddedEvent;
import com.khalanirek.stockmarket.avro.investmentportfolio.ShareBlockedEvent;
import com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent;
import com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent;
import com.khalanirek.stockmarket.avro.order.Share;
import com.khalanirek.stockmarket.company.dto.CompanyEventsDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioEventsDto;
import com.khalanirek.stockmarket.investor.dto.InvestorEventsDto;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import com.khalanirek.stockmarket.order.dto.OrderEventsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

import static com.khalanirek.stockmarket.infrastructure.KafkaConfiguration.Topics.*;

@RequiredArgsConstructor
class KafkaPublisher implements KafkaPublisherClient {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishEvent(AccountEventsDto.AccountCreated event) {
        AccountCreatedEvent accountCreatedEvent = AccountCreatedEvent.newBuilder()
                .setAccountId(event.getAccountId().toString())
                .setOwnerId(event.getOwnerId().toString())
                .build();
        kafkaTemplate.send(ACCOUNTS, accountCreatedEvent);
    }

    @Override
    public void publishEvent(AccountEventsDto.FundsBlocked event) {
        FundsBlockedEvent fundsBlockedEvent = FundsBlockedEvent.newBuilder()
                .setAccountId(event.getAccountId().toString())
                .setAmount(event.getAmount().toString())
                .setExpirationTime(event.getExpirationTime().toString()).build();
        kafkaTemplate.send(ACCOUNTS, fundsBlockedEvent);
    }

    @Override
    public void publishEvent(AccountEventsDto.FundsDeposited event) {
        FundsDepositedEvent fundsDepositedEvent = FundsDepositedEvent.newBuilder()
                .setAccountId(event.getAccountId().toString())
                .setAmount(event.getAmount().toString())
                .build();
        kafkaTemplate.send(ACCOUNTS, fundsDepositedEvent);
    }

    @Override
    public void publishEvent(AccountEventsDto.FundsWithdrew event) {
        FundsWithdrewEvent fundsWithdrewEvent = FundsWithdrewEvent.newBuilder()
                .setAccountId(event.getAccountId().toString())
                .setAmount(event.getAmount().toString())
                .build();
        kafkaTemplate.send(ACCOUNTS, fundsWithdrewEvent);
    }

    @Override
    public void publishEvent(CompanyEventsDto.CompanyRegisteredEvent event) {
        CompanyRegisteredEvent companyRegisteredEvent = CompanyRegisteredEvent.newBuilder()
                .setCompanyId(event.getCompanyId().toString())
                .setName(event.getName())
                .setSymbol(event.getSymbol())
                .setShareCapital(event.getShareCapital().toString())
                .setSharesQuantity(event.getSharesQuantity())
                .build();
        kafkaTemplate.send(COMPANIES, companyRegisteredEvent);
    }

    @Override
    public void publishEvent(InvestmentPortfolioEventsDto.InvestmentPortfolioCreated event) {
        InvestmentPortfolioCreatedEvent investmentPortfolioCreatedEvent = InvestmentPortfolioCreatedEvent.newBuilder()
                .setInvestmentPortfolioId(event.getInvestmentPortfolioId().toString())
                .build();
        kafkaTemplate.send(INVESTMENT_PORTFOLIOS, investmentPortfolioCreatedEvent);
    }

    @Override
    public void publishEvent(InvestmentPortfolioEventsDto.ShareAdded event) {
        ShareAddedEvent shareAddedEvent = ShareAddedEvent.newBuilder()
                .setInvestmentPortfolioId(event.getInvestmentPortfolioId().toString())
                .setCompanyId(event.getCompanyId().toString())
                .setQuantity(event.getQuantity())
                .build();
        kafkaTemplate.send(INVESTMENT_PORTFOLIOS, shareAddedEvent);
    }

    @Override
    public void publishEvent(InvestmentPortfolioEventsDto.ShareBlocked event) {
        ShareBlockedEvent shareAddedEvent = ShareBlockedEvent.newBuilder()
                .setInvestmentPortfolioId(event.getInvestmentPortfolioId().toString())
                .setCompanyId(event.getCompanyId().toString())
                .setQuantity(event.getQuantity())
                .setExpirationTime(event.getExpirationTime().toString())
                .build();
        kafkaTemplate.send(INVESTMENT_PORTFOLIOS, shareAddedEvent);
    }

    @Override
    public void publishEvent(InvestorEventsDto.InvestorRegisteredEvent event) {
        InvestorRegisteredEvent investorRegisteredEvent = InvestorRegisteredEvent.newBuilder()
                .setInvestorId(event.getInvestorId().toString())
                .setAccountId(event.getAccountId().toString())
                .setInvestmentPortfolioId(event.getInvestmentPortfolioId().toString())
                .setName(event.getName())
                .setSurname(event.getSurname())
                .build();
        kafkaTemplate.send(INVESTORS, investorRegisteredEvent);
    }

    @Override
    public void publishEvent(OrderEventsDto.OrderSubmittedEvent event) {
        OrderDto.Share share = event.getShare();
        OrderSubmittedEvent orderSubmittedEvent = OrderSubmittedEvent.newBuilder()
                .setOrderId(event.getOrderId().toString())
                .setInvestorId(event.getInvestorId().toString())
                .setOrderType(event.getOrderType().toString())
                .setShare(Share.newBuilder()
                        .setCompanyId(share.getCompanyId().toString())
                        .setQuantity(share.getQuantity())
                        .setPrice(share.getPrice().toString())
                        .build())
                .build();
        kafkaTemplate.send(ORDERS, orderSubmittedEvent);
    }

}
