package com.khalanirek.stockmarket.order.dto;

import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@UtilityClass
public class OrderDto {

    @Value
    @Builder
    public static class SubmitOrder {


        InvestorId investorId;

        OrderType orderType;

        Share share;

        ZonedDateTime expirationTime;

    }

    @Value
    @Builder
    public static class Order {

        OrderId id;
        
        InvestorId investorId;

        OrderType orderType;

        Share share;

        ZonedDateTime expirationTime;

    }

    @Value
    @Builder
    public static class Share {

        CompanyId companyId;

        long quantity;

        BigDecimal price;

    }

}
