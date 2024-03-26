package com.khalanirek.stockmarket.order.domain

import com.khalanirek.stockmarket.common.UUIDContext
import com.khalanirek.stockmarket.order.dto.OrderEventsDto

import static com.khalanirek.stockmarket.order.dto.OrderFixture.Dto.newOrderA
import static com.khalanirek.stockmarket.order.dto.OrderFixture.ORDER_A_ID_UUID
import static com.khalanirek.stockmarket.order.dto.OrderFixture.Dto.submitOrderA

class OrderFacadeSpec extends OrderBaseSpec {

    def "should submit order"() {
        given:
            UUIDContext.setFixtureUUID(ORDER_A_ID_UUID)
        when:
            def orderId = orderCommandFacade.submitOrder(submitOrderA())
        then:
            orderQueryFacade.findOrderById(orderId) == newOrderA()
            applicationEventPublisher.lastEvent instanceof OrderEventsDto.OrderSubmittedEvent
    }

}
