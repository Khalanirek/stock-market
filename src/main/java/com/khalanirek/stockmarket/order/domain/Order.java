package com.khalanirek.stockmarket.order.domain;

import com.khalanirek.stockmarket.common.BaseEntity;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import com.khalanirek.stockmarket.order.dto.OrderId;
import com.khalanirek.stockmarket.order.dto.OrderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "share_order")
class Order extends BaseEntity<OrderId> {

    private UUID investorId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Embedded
    private Share share;

    private ZonedDateTime expirationTime;

    @Transient
    BigDecimal getValue() {
        return share.getValue();
    }

    OrderDto.Order toDto() {
        return OrderDto.Order.builder()
                .id(OrderId.of(id))
                .investorId(InvestorId.of(investorId))
                .orderType(orderType)
                .share(share.toDto())
                .expirationTime(expirationTime)
                .build();
    }
    @Override
    protected OrderId id() {
        return OrderId.of(id);
    }

}
