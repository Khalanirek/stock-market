package com.khalanirek.stockmarket

import com.khalanirek.stockmarket.account.dto.AccountApi
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioApi
import com.khalanirek.stockmarket.investor.dto.InvestorApi
import org.springframework.boot.test.web.client.TestRestTemplate

import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_API_BASE_URL
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_API_BASE_URL
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.INVESTMENT_PORTFOLIO_API_BASE_URL

class TestWebClient {

    private final TestRestTemplate restTemplate
    final InvestorWebClient investor = new InvestorWebClient()
    final AccountWebClient account = new AccountWebClient()
    final InvestmentPortfolioWebClient investmentPortfolio = new InvestmentPortfolioWebClient()

    TestWebClient(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate
    }

    class InvestorWebClient {

        UUID registerInvestor(InvestorApi.RegisterInvestorRequest request) {
            return restTemplate.postForEntity(INVESTOR_API_BASE_URL, request, UUID).getBody()
        }

        InvestorApi.InvestorDetails getInvestorDetails(UUID id) {
            return restTemplate.getForEntity(INVESTOR_API_BASE_URL + "/${id}", InvestorApi.InvestorDetails).getBody()
        }

    }

    class AccountWebClient {

        AccountApi.AccountDetails getAccountDetails(UUID id) {
            return restTemplate.getForEntity(ACCOUNT_API_BASE_URL + "/${id}", AccountApi.AccountDetails).getBody()
        }

    }

    class InvestmentPortfolioWebClient {

        InvestmentPortfolioApi.InvestmentPortfolioDetails getInvestmentPortfolioDetails(UUID id) {
            return restTemplate.getForEntity(INVESTMENT_PORTFOLIO_API_BASE_URL + "/${id}", InvestmentPortfolioApi.InvestmentPortfolioDetails).getBody()
        }

    }

}
