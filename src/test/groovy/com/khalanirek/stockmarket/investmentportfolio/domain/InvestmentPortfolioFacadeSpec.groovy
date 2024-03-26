package com.khalanirek.stockmarket.investmentportfolio.domain

import com.khalanirek.stockmarket.common.TimeContext
import com.khalanirek.stockmarket.common.UUIDContext
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioEventsDto

import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.COMPANY_A_ID
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.INVESTMENT_PORTFOLIO_A_ID_UUID
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.INVESTMENT_PORTFOLIO_A_OWNER_ID
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.Dto.newInvestmentPortfolioA

class InvestmentPortfolioFacadeSpec extends InvestmentPortfolioBaseSpec {

    def "should create investment portfolio for investor"() {
        given:
            UUIDContext.setFixtureUUID(INVESTMENT_PORTFOLIO_A_ID_UUID)
        when:
            def portfolioId = investmentPortfolioCommandFacade.createInvestmentPortfolio(INVESTMENT_PORTFOLIO_A_OWNER_ID)
        then:
            investmentPortfolioQueryFacade.findInvestmentPortfolioById(portfolioId) == newInvestmentPortfolioA()
            applicationEventPublisher.lastEvent instanceof InvestmentPortfolioEventsDto.InvestmentPortfolioCreated
    }

    def "should add share to investment portfolio"() {
        given:
            UUIDContext.setFixtureUUID(INVESTMENT_PORTFOLIO_A_ID_UUID)
            def portfolioId = investmentPortfolioCommandFacade.createInvestmentPortfolio(INVESTMENT_PORTFOLIO_A_OWNER_ID)
        when:
            investmentPortfolioCommandFacade.addShare(portfolioId, COMPANY_A_ID, 100)
        then:
            def portfolio = investmentPortfolioQueryFacade.findInvestmentPortfolioById(portfolioId)
            portfolio.shares[0].availableQuantity == 100
            applicationEventPublisher.lastEvent instanceof InvestmentPortfolioEventsDto.ShareAdded
    }

    def "should block shares"() {
        given:
            UUIDContext.setFixtureUUID(INVESTMENT_PORTFOLIO_A_ID_UUID)
            def portfolioId = investmentPortfolioCommandFacade.createInvestmentPortfolio(INVESTMENT_PORTFOLIO_A_OWNER_ID)
            investmentPortfolioCommandFacade.addShare(portfolioId, COMPANY_A_ID, 100)
        when:
            investmentPortfolioCommandFacade.blockShares(portfolioId, COMPANY_A_ID, 50, TimeContext.zonedNow().plusMonths(1))
        then:
            def portfolio = investmentPortfolioQueryFacade.findInvestmentPortfolioById(portfolioId)
            portfolio.shares[0].availableQuantity == 50
        applicationEventPublisher.lastEvent instanceof InvestmentPortfolioEventsDto.ShareBlocked
    }

}
