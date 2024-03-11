package com.khalanirek.stockmarket.investor.domain

import com.khalanirek.stockmarket.common.UUIDContext

import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Dto.investorA
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_A_ACCOUNT_ID_UUID
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_A_ID_UUID
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_A_INVESTMENT_PORTFOLIO_ID_UUID

import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Dto.registerInvestorA

class InvestorFacadeSpec extends InvestorBaseSpec {

    def "should register investor"() {
        given:
            UUIDContext.setFixtureUUIDList(List.of(
                    INVESTOR_A_INVESTMENT_PORTFOLIO_ID_UUID,
                    INVESTOR_A_ACCOUNT_ID_UUID,
                    INVESTOR_A_ID_UUID))
        when:
            def id = investorCommandFacade.registerInvestor(registerInvestorA())
        then:
            investorQueryFacade.findInvestorById(id) == investorA()
    }

}
