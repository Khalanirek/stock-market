package com.khalanirek.stockmarket.investmentportfolio.domain

import com.khalanirek.stockmarket.common.TestApplicationEventPublisher
import com.khalanirek.stockmarket.common.TimeContext
import com.khalanirek.stockmarket.common.UUIDContext
import spock.lang.Specification

class InvestmentPortfolioBaseSpec extends Specification{

    TestApplicationEventPublisher applicationEventPublisher = new TestApplicationEventPublisher()
    InvestmentPortfolioRepository investmentPortfolioRepository = new InMemoryInvestmentPortfolioRepository()
    InvestmentPortfolioConfiguration investmentPortfolioConfiguration = new InvestmentPortfolioConfiguration(applicationEventPublisher, investmentPortfolioRepository)
    InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade = investmentPortfolioConfiguration.investmentPortfolioCommandFacade()
    InvestmentPortfolioQueryFacade investmentPortfolioQueryFacade = investmentPortfolioConfiguration.investmentPortfolioQueryFacade()

    def cleanup() {
        TimeContext.clear()
        UUIDContext.clear()
        applicationEventPublisher.clear()
    }

}
