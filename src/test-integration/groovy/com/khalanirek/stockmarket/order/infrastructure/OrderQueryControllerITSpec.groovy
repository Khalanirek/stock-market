package com.khalanirek.stockmarket.order.infrastructure

import com.khalanirek.stockmarket.order.domain.OrderQueryFacade
import com.khalanirek.stockmarket.order.dto.OrderApi
import com.khalanirek.stockmarket.order.dto.OrderId
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.khalanirek.stockmarket.common.BaseFixture.fromJson
import static com.khalanirek.stockmarket.order.dto.OrderFixture.Dto.newOrderA
import static com.khalanirek.stockmarket.order.dto.OrderFixture.ORDER_A_ID_UUID
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static com.khalanirek.stockmarket.order.dto.OrderFixture.ORDER_API_BASE_URL
import static com.khalanirek.stockmarket.order.dto.OrderFixture.Api.newOrderDetailsA

@WebMvcTest(OrderQueryController.class)
class OrderQueryControllerITSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    @SpringBean
    OrderQueryFacade orderQueryFacade = Mock(OrderQueryFacade) {
        findOrderById(_ as OrderId) >> newOrderA()
    }

    def "should get order details"() {
        when:
        def result = mockMvc.perform(get(ORDER_API_BASE_URL + "/${ORDER_A_ID_UUID}")
                .accept(APPLICATION_JSON))
        then:
        def response = result
                .andExpect(status().isOk())
                .andReturn().response
        fromJson(response.getContentAsString(), OrderApi.OrderDetails.class) == newOrderDetailsA()
    }

}
