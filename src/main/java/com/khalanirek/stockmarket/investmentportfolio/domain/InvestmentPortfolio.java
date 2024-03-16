package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.common.BaseEntity;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "investment_portfolio")
class InvestmentPortfolio extends BaseEntity<InvestmentPortfolioId> {

    private UUID ownerId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "investment_portfolio_id")
    private Set<Share> shares;

    InvestmentPortfolioDto.InvestmentPortfolio toDto() {
        return InvestmentPortfolioDto.InvestmentPortfolio.builder()
                .id(InvestmentPortfolioId.of(id))
                .ownerId(InvestorId.of(ownerId))
                .shares(shares.stream()
                        .map(Share::toDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    @Override
    protected InvestmentPortfolioId id() {
        return InvestmentPortfolioId.of(id);
    }

}
