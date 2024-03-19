package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.common.BaseEntity;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioExceptions;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.Optional;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "investment_portfolio_id")
    private Set<ShareBlockade> shareBlockades;

    void blockShares(CompanyId companyId, long quantity, ZonedDateTime expirationTime) {
        Share share = findShare(companyId).orElseThrow();
        if (share.getQuantity() < quantity) {
            throw new InvestmentPortfolioExceptions.NotEnoughShares(id(), companyId);
        }
        shareBlockades.add(ShareBlockade.builder()
                        .companyId(companyId.getId())
                        .quantity(quantity)
                        .expirationTime(expirationTime)
                .build());
    }

    void addShare(CompanyId companyId, long quantity) {
        Optional<Share> existingShare = findShare(companyId);
        Share share;
        if (existingShare.isEmpty()) {
            share = InvestmentPortfolioFactory.createShare(companyId);
            shares.add(share);
        } else {
            share = existingShare.get();
        }
        share.increaseQuantity(quantity);
    }

    private Optional<Share> findShare(CompanyId companyId) {
        return shares.stream()
                .filter(share -> share.getCompanyId().equals(companyId.getId()))
                .findFirst();
    }

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
