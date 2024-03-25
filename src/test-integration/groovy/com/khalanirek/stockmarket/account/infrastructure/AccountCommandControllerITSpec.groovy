package com.khalanirek.stockmarket.account.infrastructure

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade
import com.khalanirek.stockmarket.account.dto.AccountId
import com.khalanirek.stockmarket.company.domain.CompanyCommandFacade
import com.khalanirek.stockmarket.company.dto.CompanyDto
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_A_ID_UUID
import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_API_BASE_URL
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(AccountCommandController.class)
class AccountCommandControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc;

    @SpringBean
    private AccountCommandFacade accountCommandFacade = Mock(AccountCommandFacade)


    def "should deposit funds"() {
        when:
        def result = mockMvc.perform(post(ACCOUNT_API_BASE_URL + "/$ACCOUNT_A_ID_UUID/deposit")
                .param("amount", String.valueOf(10_000)))
        then:
            result.andExpect(status().isOk())
    }

    def "should withdraw funds"() {
        when:
        def result = mockMvc.perform(post(ACCOUNT_API_BASE_URL + "/$ACCOUNT_A_ID_UUID/withdraw")
                .param("amount", String.valueOf(10_000)))
        then:
        result.andExpect(status().isOk())
    }

}
