package com.khalanirek.stockmarket.order.dto;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@UtilityClass
public class OrderApi {

    @Value
    @Builder
    public static class SubmitOrderRequest {


        UUID investorId;

        OrderType orderType;

        Share share;

        ZonedDateTime expirationTime;

    }

    @Value
    @Builder
    public static class OrderDetails {

        UUID id;

        UUID investorId;

        OrderType orderType;

        Share share;

        ZonedDateTime expirationTime;

    }

    @Value
    @Builder
    public static class Share {

        UUID companyId;

        long quantity;

        BigDecimal price;

    }

}
