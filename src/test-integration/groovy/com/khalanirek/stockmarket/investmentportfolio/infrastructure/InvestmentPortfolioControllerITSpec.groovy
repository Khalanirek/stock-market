package com.khalanirek.stockmarket.investmentportfolio.infrastructure

import com.khalanirek.stockmarket.investmentportfolio.domain.InvestmentPortfolioQueryFacade
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioApi
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.INVESTMENT_PORTFOLIO_API_BASE_URL
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.Dto.newInvestmentPortfolioA
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.Api.newInvestmentPortfolioADetails
import static com.khalanirek.stockmarket.common.BaseFixture.fromJson
import static com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioFixture.INVESTMENT_PORTFOLIO_A_ID_UUID
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(InvestmentPortfolioQueryController.class)
class InvestmentPortfolioControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    @SpringBean
    private InvestmentPortfolioQueryFacade investmentPortfolioQueryFacade = Mock(InvestmentPortfolioQueryFacade) {
        findInvestmentPortfolioById(_ as InvestmentPortfolioId) >> { return newInvestmentPortfolioA() }
    }

    def "should get investment portfolio details"() {
        when:
        def result = mockMvc.perform(get(INVESTMENT_PORTFOLIO_API_BASE_URL + "/${INVESTMENT_PORTFOLIO_A_ID_UUID}")
                .accept(APPLICATION_JSON))
        then:
        def response = result
                .andExpect(status().isOk())
                .andReturn().response
        fromJson(response.getContentAsString(), InvestmentPortfolioApi.InvestmentPortfolioDetails.class) == newInvestmentPortfolioADetails()
    }

}
