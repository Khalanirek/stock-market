package com.khalanirek.stockmarket.order.domain;

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade;
import com.khalanirek.stockmarket.investmentportfolio.domain.InvestmentPortfolioCommandFacade;
import com.khalanirek.stockmarket.investor.domain.InvestorQueryFacade;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import com.khalanirek.stockmarket.order.dto.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

import static com.khalanirek.stockmarket.order.dto.OrderType.BUY;

@RequiredArgsConstructor
@Transactional
public class OrderCommandFacade {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final OrderRepository orderRepository;
    private final InvestorQueryFacade investorQueryFacade;
    private final AccountCommandFacade accountCommandFacade;
    private final InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade;

    public OrderId submitOrder(OrderDto.SubmitOrder dto) {
        Order order = OrderFactory.Domain.createOrder(dto);
        InvestorDto.Investor investor = investorQueryFacade.findInvestorById(dto.getInvestorId());
        if (dto.getOrderType() == BUY) {
            accountCommandFacade.blockFunds(investor.getAccountId(), order.getValue(), dto.getExpirationTime());
        } else {
            investmentPortfolioCommandFacade.blockShares(investor.getInvestmentPortfolioId(), dto.getShare().getCompanyId(),
                    dto.getShare().getQuantity(), dto.getExpirationTime());
        }
        orderRepository.save(order);
        applicationEventPublisher.publishEvent(OrderFactory.EventsDto.toOrderSubmitted(order));
        return order.id();
    }

}
