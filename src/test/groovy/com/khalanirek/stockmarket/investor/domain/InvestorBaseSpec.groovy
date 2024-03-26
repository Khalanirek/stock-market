package com.khalanirek.stockmarket.investor.domain

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade
import com.khalanirek.stockmarket.common.TestApplicationEventPublisher
import com.khalanirek.stockmarket.common.TimeContext
import com.khalanirek.stockmarket.common.UUIDContext
import com.khalanirek.stockmarket.investmentportfolio.domain.InvestmentPortfolioCommandFacade
import com.khalanirek.stockmarket.investor.dto.InvestorId
import org.springframework.context.ApplicationEventPublisher
import spock.lang.Specification

import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_A_ACCOUNT_ID
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_A_INVESTMENT_PORTFOLIO_ID

class InvestorBaseSpec extends Specification {

    ApplicationEventPublisher applicationEventPublisher = new TestApplicationEventPublisher()

    AccountCommandFacade accountCommandFacade = Mock(AccountCommandFacade) {
        createAccount(_ as InvestorId) >> { INVESTOR_A_ACCOUNT_ID }
    }

    InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade = Mock(InvestmentPortfolioCommandFacade) {
        createInvestmentPortfolio(_ as InvestorId) >> { INVESTOR_A_INVESTMENT_PORTFOLIO_ID }
    }

    InvestorRepository investorRepository = new InMemoryInvestorRepository()
    InvestorConfiguration investorConfiguration = new InvestorConfiguration(applicationEventPublisher, investorRepository, accountCommandFacade, investmentPortfolioCommandFacade)
    InvestorCommandFacade investorCommandFacade = investorConfiguration.investorCommandFacade()
    InvestorQueryFacade investorQueryFacade = investorConfiguration.investorQueryFacade()

    def cleanup() {
        TimeContext.clear()
        UUIDContext.clear()
        applicationEventPublisher.clear()
    }

}
