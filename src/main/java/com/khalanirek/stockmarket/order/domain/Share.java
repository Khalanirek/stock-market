package com.khalanirek.stockmarket.order.domain;

import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@Embeddable
class Share {

    private UUID companyId;

    private long quantity;

    private BigDecimal price;

    OrderDto.Share toDto() {
        return OrderDto.Share.builder()
                .companyId(CompanyId.of(companyId))
                .quantity(quantity)
                .price(price)
                .build();
    }

    BigDecimal getValue() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
