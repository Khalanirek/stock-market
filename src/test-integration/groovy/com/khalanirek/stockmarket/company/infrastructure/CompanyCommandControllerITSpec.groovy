package com.khalanirek.stockmarket.company.infrastructure

import com.khalanirek.stockmarket.company.domain.CompanyCommandFacade
import com.khalanirek.stockmarket.company.dto.CompanyDto
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.common.BaseFixture.toJson
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_API_BASE_URL
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.Api.registerCompanyA
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_ID
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(CompanyCommandController.class)
class CompanyCommandControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc;

    @SpringBean
    private CompanyCommandFacade companyCommandFacade = Mock(CompanyCommandFacade) {
        registerCompany(_ as CompanyDto.RegisterCompany) >> { return COMPANY_A_ID }
    }


    def "should register company"() {
        when:
            def result = mockMvc.perform(post(COMPANY_API_BASE_URL)
                    .contentType(APPLICATION_JSON)
                    .content(toJson(registerCompanyA())))
        then:
            result.andExpect(status().isOk())

    }

}
