package com.khalanirek.stockmarket.order.infrastructure

import com.khalanirek.stockmarket.investor.domain.InvestorQueryFacade
import com.khalanirek.stockmarket.order.domain.OrderCommandFacade
import com.khalanirek.stockmarket.order.dto.OrderDto
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.common.BaseFixture.toJson
import static com.khalanirek.stockmarket.investor.dto.InvestorFixture.Dto.investorA
import static com.khalanirek.stockmarket.order.dto.OrderFixture.Api.submitOrderARequest
import static com.khalanirek.stockmarket.order.dto.OrderFixture.ORDER_API_BASE_URL
import static com.khalanirek.stockmarket.order.dto.OrderFixture.ORDER_A_ID
import static com.khalanirek.stockmarket.order.dto.OrderFixture.getINVESTOR_A_ID
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(OrderCommandController.class)
class OrderCommandControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc;

    @SpringBean
    private OrderCommandFacade orderCommandFacade = Mock(OrderCommandFacade) {
        submitOrder(_ as OrderDto.SubmitOrder) >> { return ORDER_A_ID }
    }

    @SpringBean
    InvestorQueryFacade investorQueryFacade = Mock(InvestorQueryFacade) {
        findInvestorById(INVESTOR_A_ID) >> { investorA() }
    }

    def "should submit order"() {
        when:
            def result = mockMvc.perform(post(ORDER_API_BASE_URL)
                    .contentType(APPLICATION_JSON)
                    .content(toJson(submitOrderARequest())))
        then:
            result.andExpect(status().isCreated())
    }

}
