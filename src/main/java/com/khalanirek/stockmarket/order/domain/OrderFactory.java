package com.khalanirek.stockmarket.order.domain;

import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class OrderFactory {

    static Order createOrder(OrderDto.SubmitOrder dto) {
        return Order.builder()
                .id(UUIDContext.randomUUID())
                .investorId(dto.getInvestorId().getId())
                .orderType(dto.getOrderType())
                .expirationTime(dto.getExpirationTime())
                .share(toShare(dto.getShare()))
                .build();
    }

    private Share toShare(OrderDto.Share dto) {
        return Share.builder()
                .companyId(dto.getCompanyId().getId())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();
    }

}
