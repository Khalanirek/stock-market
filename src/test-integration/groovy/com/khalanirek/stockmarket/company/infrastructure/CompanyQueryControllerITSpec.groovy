package com.khalanirek.stockmarket.company.infrastructure


import com.khalanirek.stockmarket.company.domain.CompanyQueryFacade
import com.khalanirek.stockmarket.company.dto.CompanyApi
import com.khalanirek.stockmarket.company.dto.CompanyId
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.common.BaseFixture.fromJson
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.Api.companyADetails
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_API_BASE_URL
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_ID_UUID
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.Dto.companyA
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(CompanyQueryController.class)
class CompanyQueryControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc;

    @SpringBean
    private CompanyQueryFacade companyQueryFacade = Mock(CompanyQueryFacade) {
        findCompanyById(_ as CompanyId) >> { return companyA() }
    }


    def "should get company details"() {
        when:
            def result = mockMvc.perform(get(COMPANY_API_BASE_URL + "/${COMPANY_A_ID_UUID}")
                    .accept(APPLICATION_JSON))
        then:
            def response = result
                    .andExpect(status().isOk())
                    .andReturn().response
            fromJson(response.getContentAsString(), CompanyApi.CompanyDetails.class) == companyADetails()

    }

}
