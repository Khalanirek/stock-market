package com.khalanirek.stockmarket.order.domain

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade
import com.khalanirek.stockmarket.investmentportfolio.domain.InvestmentPortfolioCommandFacade
import com.khalanirek.stockmarket.investor.domain.InvestorQueryFacade
import spock.lang.Specification

import static com.khalanirek.stockmarket.order.dto.OrderFixture.INVESTOR_A_ID
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Dto.investorA

class OrderBaseSpec extends Specification {

    OrderRepository orderRepository = new InMemoryOrderRepository()
    InvestorQueryFacade investorQueryFacade = Mock(InvestorQueryFacade) {
        findInvestorById(INVESTOR_A_ID) >> { investorA() }
    }
    AccountCommandFacade accountCommandFacade = Mock(AccountCommandFacade)
    InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade = Mock(InvestmentPortfolioCommandFacade)

    OrderConfiguration orderConfiguration = new OrderConfiguration(orderRepository, investorQueryFacade, accountCommandFacade, investmentPortfolioCommandFacade)
    OrderCommandFacade orderCommandFacade = orderConfiguration.orderCommandFacade()
    OrderQueryFacade orderQueryFacade = orderConfiguration.orderQueryFacade()

}
