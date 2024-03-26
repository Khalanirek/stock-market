package com.khalanirek.stockmarket.order.domain;

import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import com.khalanirek.stockmarket.order.dto.OrderEventsDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class OrderFactory {

    static class Domain {

        static Order createOrder(OrderDto.SubmitOrder dto) {
            return Order.builder()
                    .id(UUIDContext.randomUUID())
                    .investorId(dto.getInvestorId().getId())
                    .orderType(dto.getOrderType())
                    .expirationTime(dto.getExpirationTime())
                    .share(toShare(dto.getShare()))
                    .build();
        }

        private static Share toShare(OrderDto.Share dto) {
            return Share.builder()
                    .companyId(dto.getCompanyId().getId())
                    .quantity(dto.getQuantity())
                    .price(dto.getPrice())
                    .build();
        }

    }

    static class EventsDto {

        static OrderEventsDto.OrderSubmittedEvent toOrderSubmitted(Order order) {
            return OrderEventsDto.OrderSubmittedEvent.builder()
                    .orderId(order.id())
                    .investorId(InvestorId.of(order.getInvestorId()))
                    .orderType(order.getOrderType())
                    .share(toShare(order.getShare()))
                    .expirationTime(order.getExpirationTime())
                    .build();
        }

        private static OrderDto.Share toShare(Share share) {
            return OrderDto.Share.builder()
                    .companyId(CompanyId.of(share.getCompanyId()))
                    .quantity(share.getQuantity())
                    .price(share.getPrice())
                    .build();
        }

    }

}
