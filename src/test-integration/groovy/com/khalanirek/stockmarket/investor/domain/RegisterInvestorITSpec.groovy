package com.khalanirek.stockmarket.investor.domain

import com.khalanirek.stockmarket.ApplicationBaseWorkflow

import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Api.registerInvestorARequest

class RegisterInvestorITSpec extends ApplicationBaseWorkflow {

    def "should register investor"() {
        given:
            def registerInvestorRequest = registerInvestorARequest()
        when:
            def investorId = webClient.investor.registerInvestor(registerInvestorRequest)
        then: "investor is created"
            def investorDetails = webClient.investor.getInvestorDetails(investorId)
            verifyAll(investorDetails) {
                id != null
                accountId != null
                investmentPortfolioId != null
                name == registerInvestorRequest.name
                surname == registerInvestorRequest.surname
            }
        and: "account is created"
            def accountDetails = webClient.account.getAccountDetails(investorDetails.accountId)
            verifyAll(accountDetails) {
                id == investorDetails.accountId
                ownerId == investorDetails.id
                balance == 0
            }
        and: "investment portfolio is created"
            def investmentPortfolioDetails = webClient.investmentPortfolio.getInvestmentPortfolioDetails(investorDetails.investmentPortfolioId)
            verifyAll(investmentPortfolioDetails) {
                id == investorDetails.investmentPortfolioId
                ownerId == investorDetails.id
                shares == List.of()
            }
    }

}
