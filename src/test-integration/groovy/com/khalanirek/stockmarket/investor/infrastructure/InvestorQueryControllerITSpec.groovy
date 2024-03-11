package com.khalanirek.stockmarket.investor.infrastructure

import com.khalanirek.stockmarket.investor.domain.InvestorQueryFacade
import com.khalanirek.stockmarket.investor.dto.InvestorApi
import com.khalanirek.stockmarket.investor.dto.InvestorId
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.common.BaseFixture.fromJson
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Api.investorADetails
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Dto.investorA
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_API_BASE_URL
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_A_ID_UUID
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(InvestorQueryController.class)
class InvestorQueryControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc;

    @SpringBean
    private InvestorQueryFacade investorQueryFacade = Mock(InvestorQueryFacade) {
        findInvestorById(_ as InvestorId) >> { return investorA() }
    }

    def "should register investor"() {
        when:
            def result = mockMvc.perform(get(INVESTOR_API_BASE_URL + "/${INVESTOR_A_ID_UUID}")
                    .accept(APPLICATION_JSON))
        then:
            def response = result
                    .andExpect(status().isOk())
                    .andReturn().response
            fromJson(response.getContentAsString(), InvestorApi.InvestorDetails) == investorADetails()
    }

}
