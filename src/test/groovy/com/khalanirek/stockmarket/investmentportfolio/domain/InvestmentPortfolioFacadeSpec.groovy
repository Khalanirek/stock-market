package com.khalanirek.stockmarket.investmentportfolio.domain

import com.khalanirek.stockmarket.common.UUIDContext

import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.INVESTMENT_PORTFOLIO_A_ID_UUID
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.INVESTMENT_PORTFOLIO_A_OWNER_ID
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.Dto.newInvestmentPortfolioA

class InvestmentPortfolioFacadeSpec extends InvestmentPortfolioBaseSpec {

    def "should create investment portfolio for investor"() {
        given:
            UUIDContext.setFixtureUUID(INVESTMENT_PORTFOLIO_A_ID_UUID)
        when:
            def id = investmentPortfolioCommandFacade.createInvestmentPortfolio(INVESTMENT_PORTFOLIO_A_OWNER_ID)
        then:
            investmentPortfolioQueryFacade.findInvestmentPortfolioById(id) == newInvestmentPortfolioA()
    }

}
