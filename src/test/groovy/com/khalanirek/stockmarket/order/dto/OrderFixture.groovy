package com.khalanirek.stockmarket.order.dto

import com.khalanirek.stockmarket.common.TimeContext
import com.khalanirek.stockmarket.company.dto.CompanyId
import com.khalanirek.stockmarket.investor.dto.InvestorId

import java.time.ZonedDateTime

import static com.khalanirek.stockmarket.order.dto.OrderType.BUY

class OrderFixture {

    static final String ORDER_API_BASE_URL = "/api/orders"
    static final UUID ORDER_A_ID_UUID = UUID.randomUUID()
    static final OrderId ORDER_A_ID = OrderId.of(ORDER_A_ID_UUID)
    static final UUID INVESTOR_A_ID_UUID = UUID.randomUUID()
    static final InvestorId INVESTOR_A_ID = InvestorId.of(INVESTOR_A_ID_UUID)
    static final OrderType ORDER_A_TYPE = BUY
    static final UUID COMPANY_A_ID_UUID = UUID.randomUUID()
    static final CompanyId COMPANY_A_ID = CompanyId.of(COMPANY_A_ID_UUID)
    static final ZonedDateTime ORDER_A_EXPIRATION_TIME = TimeContext.zonedNow().plusMonths(1)

    static class Dto {

        static OrderDto.SubmitOrder submitOrderA() {
            return OrderDto.SubmitOrder.builder()
                    .investorId(INVESTOR_A_ID)
                    .orderType(ORDER_A_TYPE)
                    .share(OrderDto.Share.builder()
                            .companyId(COMPANY_A_ID)
                            .quantity(100)
                            .price(10 as BigDecimal)
                            .build())
                    .expirationTime(ORDER_A_EXPIRATION_TIME)
                    .build()
        }

        static OrderDto.Order newOrderA() {
            return OrderDto.Order.builder()
                    .id(ORDER_A_ID)
                    .investorId(INVESTOR_A_ID)
                    .orderType(ORDER_A_TYPE)
                    .share(OrderDto.Share.builder()
                            .companyId(COMPANY_A_ID)
                            .quantity(100)
                            .price(10 as BigDecimal)
                            .build())
                    .expirationTime(ORDER_A_EXPIRATION_TIME)
                    .build()
        }

    }

    static class Api {

        static OrderApi.SubmitOrderRequest submitOrderA() {
            return OrderApi.SubmitOrderRequest.builder()
                    .investorId(INVESTOR_A_ID_UUID)
                    .orderType(ORDER_A_TYPE)
                    .share(OrderApi.Share.builder()
                            .companyId(COMPANY_A_ID_UUID)
                            .quantity(100)
                            .price(10 as BigDecimal)
                            .build())
                    .expirationTime(ORDER_A_EXPIRATION_TIME)
                    .build()
        }

        static OrderApi.OrderDetails newOrderDetailsA() {
            return OrderApi.OrderDetails.builder()
                    .id(ORDER_A_ID_UUID)
                    .investorId(INVESTOR_A_ID_UUID)
                    .orderType(ORDER_A_TYPE)
                    .share(OrderApi.Share.builder()
                            .companyId(COMPANY_A_ID_UUID)
                            .quantity(100)
                            .price(10 as BigDecimal)
                            .build())
                    .expirationTime(ORDER_A_EXPIRATION_TIME)
                    .build()
        }

    }

}
