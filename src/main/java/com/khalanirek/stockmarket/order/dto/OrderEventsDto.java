package com.khalanirek.stockmarket.order.dto;

import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class OrderEventsDto {

    public interface OrderEvent {

        OrderId getOrderId();

    }

    @Value
    @Builder
    public static class OrderSubmittedEvent implements OrderEvent {

        @NonNull
        OrderId orderId;

        @NonNull
        InvestorId investorId;

        @NonNull
        OrderType orderType;

        @NonNull
        OrderDto.Share share;

        @NonNull
        ZonedDateTime expirationTime;

    }

}
