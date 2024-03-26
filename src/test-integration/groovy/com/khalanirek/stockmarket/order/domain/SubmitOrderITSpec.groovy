package com.khalanirek.stockmarket.order.domain

import com.khalanirek.stockmarket.ApplicationBaseWorkflow
import com.khalanirek.stockmarket.company.dto.CompanyId
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId
import com.khalanirek.stockmarket.order.dto.OrderFixture

import static com.khalanirek.stockmarket.company.dto.CompanyFixture.Api.registerCompanyARequest
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Api.registerInvestorARequest
import static com.khalanirek.stockmarket.order.dto.OrderFixture.Api.submitOrderARequest
import static com.khalanirek.stockmarket.order.dto.OrderType.BUY
import static com.khalanirek.stockmarket.order.dto.OrderType.SELL

class SubmitOrderITSpec extends ApplicationBaseWorkflow {

    private static final BigDecimal DEPOSIT = 10_000
    private static final long SHARE_QUANTITY = 100
    private static final BigDecimal SHARE_PRICE = 10

    def "should submit buy order"() {
        given:
            def registeredInvestorId = webClient.investor.registerInvestor(registerInvestorARequest())
            def registeredInvestorDetails = webClient.investor.getInvestorDetails(registeredInvestorId)
            def registeredCompanyId =  webClient.company.registerCompany(registerCompanyARequest())
            webClient.account.depositFunds(registeredInvestorDetails.accountId, DEPOSIT)
            def submitOrderRequest = submitOrderARequest(registeredInvestorId, registeredCompanyId)
        when:
            def submittedOrderId = webClient.order.submitOrder(submitOrderRequest)
        then: "order is created"
            def orderDetails = webClient.order.getOrderDetails(submittedOrderId)
            verifyAll(orderDetails) {
                id != null
                investorId == registeredInvestorId
                orderType == BUY
                share.companyId == registeredCompanyId
                share.quantity == SHARE_QUANTITY
                share.price == SHARE_PRICE
                expirationTime == OrderFixture.ORDER_A_EXPIRATION_TIME
            }
        and: "funds are blocked on investor account"
            def investorDetails = webClient.investor.getInvestorDetails(orderDetails.investorId)
            def accountDetails = webClient.account.getAccountDetails(investorDetails.accountId)
            verifyAll(accountDetails) {
                ownerId == orderDetails.investorId
                availableBalance == DEPOSIT.subtract(SHARE_PRICE * BigDecimal.valueOf(SHARE_QUANTITY))
            }
    }

    def "should submit sell order"() {
        given:
            def registeredInvestorId = webClient.investor.registerInvestor(registerInvestorARequest())
            def registeredInvestorDetails = webClient.investor.getInvestorDetails(registeredInvestorId)
            def registeredCompanyId =  webClient.company.registerCompany(registerCompanyARequest())
            investmentPortfolioCommandFacade.addShare(InvestmentPortfolioId.of(registeredInvestorDetails.investmentPortfolioId), CompanyId.of(registeredCompanyId), 2 * SHARE_QUANTITY)
            def submitOrderRequest = submitOrderARequest(registeredInvestorId, registeredCompanyId, SELL)
        when:
            def submittedOrderId = webClient.order.submitOrder(submitOrderRequest)
        then: "order is created"
            def orderDetails = webClient.order.getOrderDetails(submittedOrderId)
            verifyAll(orderDetails) {
                id != null
                investorId == registeredInvestorId
                orderType == SELL
                share.companyId == registeredCompanyId
                share.quantity == SHARE_QUANTITY
                share.price == SHARE_PRICE
                expirationTime == OrderFixture.ORDER_A_EXPIRATION_TIME
            }
        and: "shares are blocked in investor investment portfolio"
            def investorDetails = webClient.investor.getInvestorDetails(orderDetails.investorId)
            def investmentPortfolioDetails = webClient.investmentPortfolio.getInvestmentPortfolioDetails(investorDetails.investmentPortfolioId)
            verifyAll(investmentPortfolioDetails) {
                ownerId == orderDetails.investorId
                shares.size() == 1
                shares[0].availableQuantity == SHARE_QUANTITY
                shares[0].blockedQuantity == SHARE_QUANTITY
            }
    }

}
