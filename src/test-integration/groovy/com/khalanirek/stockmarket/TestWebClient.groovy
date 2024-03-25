package com.khalanirek.stockmarket

import com.khalanirek.stockmarket.account.dto.AccountApi
import com.khalanirek.stockmarket.company.dto.CompanyApi
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioApi
import com.khalanirek.stockmarket.investor.dto.InvestorApi
import com.khalanirek.stockmarket.order.dto.OrderApi
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_API_BASE_URL
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_API_BASE_URL
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_API_BASE_URL
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.INVESTMENT_PORTFOLIO_API_BASE_URL
import static com.khalanirek.stockmarket.order.dto.OrderFixture.getORDER_API_BASE_URL

class TestWebClient {

    private final TestRestTemplate restTemplate
    final AccountWebClient account = new AccountWebClient()
    final CompanyWebClient company = new CompanyWebClient()
    final InvestorWebClient investor = new InvestorWebClient()
    final InvestmentPortfolioWebClient investmentPortfolio = new InvestmentPortfolioWebClient()
    final OrderWebClient order = new OrderWebClient()

    TestWebClient(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate
    }

    class AccountWebClient {

        AccountApi.AccountDetails getAccountDetails(UUID id) {
            return restTemplate.getForEntity(ACCOUNT_API_BASE_URL + "/${id}", AccountApi.AccountDetails).getBody()
        }

        void depositFunds(UUID accountId, BigDecimal amount) {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("amount", amount.toString())
            restTemplate.postForEntity(ACCOUNT_API_BASE_URL + "/${accountId}/deposit", params, Void.class)
        }

        void withdrawFunds(UUID accountId, BigDecimal amount) {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("amount", amount.toString())
            restTemplate.postForEntity(ACCOUNT_API_BASE_URL + "/${accountId}/withdraw", params, Void.class)
        }

    }

    class CompanyWebClient {

        UUID registerCompany(CompanyApi.RegisterCompanyRequest request) {
            return restTemplate.postForEntity(COMPANY_API_BASE_URL, request, UUID).getBody()
        }

        CompanyApi.CompanyDetails getCompanyDetails(UUID id) {
            return restTemplate.getForEntity(COMPANY_API_BASE_URL + "/${id}", CompanyApi.CompanyDetails).getBody()
        }

    }

    class InvestorWebClient {

        UUID registerInvestor(InvestorApi.RegisterInvestorRequest request) {
            return restTemplate.postForEntity(INVESTOR_API_BASE_URL, request, UUID).getBody()
        }

        InvestorApi.InvestorDetails getInvestorDetails(UUID id) {
            return restTemplate.getForEntity(INVESTOR_API_BASE_URL + "/${id}", InvestorApi.InvestorDetails).getBody()
        }

    }

    class InvestmentPortfolioWebClient {

        InvestmentPortfolioApi.InvestmentPortfolioDetails getInvestmentPortfolioDetails(UUID id) {
            return restTemplate.getForEntity(INVESTMENT_PORTFOLIO_API_BASE_URL + "/${id}", InvestmentPortfolioApi.InvestmentPortfolioDetails).getBody()
        }

    }

    class OrderWebClient {

        UUID submitOrder(OrderApi.SubmitOrderRequest request) {
            return restTemplate.postForEntity(ORDER_API_BASE_URL, request, UUID).getBody()
        }

        OrderApi.OrderDetails getOrderDetails(UUID id) {
            return restTemplate.getForEntity(ORDER_API_BASE_URL + "/${id}", OrderApi.OrderDetails).getBody()
        }

    }

}
