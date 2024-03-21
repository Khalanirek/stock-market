package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.common.ChildEntity;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioExceptions;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "investment_portfolio_share")
class Share extends ChildEntity {

    private UUID companyId;

    private long quantity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "investment_portfolio_share_id")
    private Set<ShareBlockade> shareBlockades;

    long getAvailableQuantity() {
        return quantity - getBlockedQuantity();
    }

    private long getBlockedQuantity() {
        return shareBlockades.stream()
                .map(ShareBlockade::getQuantity)
                .reduce(0L, Long::sum);
    }

    void increaseQuantity(long amount) {
        quantity = quantity + amount;
    }

    void blockShares(long quantityToBlock, ZonedDateTime expirationTime) {
        shareBlockades.add(ShareBlockade.builder()
                .quantity(quantityToBlock)
                .expirationTime(expirationTime)
                .build());
    }

    InvestmentPortfolioDto.Share toDto() {
        return InvestmentPortfolioDto.Share.builder()
                .companyId(CompanyId.of(companyId))
                .availableQuantity(getAvailableQuantity())
                .blockedQuantity(getBlockedQuantity())
                .build();
    }

}
