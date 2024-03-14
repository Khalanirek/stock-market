package com.khalanirek.stockmarket.account.infrastructure

import com.khalanirek.stockmarket.account.domain.AccountQueryFacade
import com.khalanirek.stockmarket.account.dto.AccountApi
import com.khalanirek.stockmarket.account.dto.AccountId
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.account.dto.AccountFixture.Dto.accountA
import static com.khalanirek.stockmarket.common.BaseFixture.fromJson
import static com.khalanirek.stockmarket.account.dto.AccountFixture.Api.accountADetails
import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_API_BASE_URL
import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_A_ID_UUID
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(AccountQueryController.class)
class AccountQueryControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    @SpringBean
    private AccountQueryFacade accountQueryFacade = Mock(AccountQueryFacade) {
        findAccountById(_ as AccountId) >> { return accountA() }
    }

    def "should get account details"() {
        when:
        def result = mockMvc.perform(get(ACCOUNT_API_BASE_URL + "/${ACCOUNT_A_ID_UUID}")
                .accept(APPLICATION_JSON))
        then:
        def response = result
                .andExpect(status().isOk())
                .andReturn().response
        fromJson(response.getContentAsString(), AccountApi.AccountDetails.class) == accountADetails()
    }

}
