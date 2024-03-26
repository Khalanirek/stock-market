package com.khalanirek.stockmarket.investor.infrastructure

import com.khalanirek.stockmarket.investor.domain.InvestorCommandFacade
import com.khalanirek.stockmarket.investor.dto.InvestorDto
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.common.BaseFixture.toJson
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_API_BASE_URL
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.INVESTOR_A_ID
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Api.registerInvestorARequest

@WebMvcTest(InvestorCommandController.class)
class InvestorCommandControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc;

    @SpringBean
    private InvestorCommandFacade investorCommandFacade = Mock(InvestorCommandFacade) {
        registerInvestor(_ as InvestorDto.RegisterInvestor) >> { return INVESTOR_A_ID }
    }

    def "should register investor"() {
        when:
        def result = mockMvc.perform(post(INVESTOR_API_BASE_URL)
                .contentType(APPLICATION_JSON)
                .content(toJson(registerInvestorARequest())))
        then:
            result.andExpect(status().isCreated())

    }

}
