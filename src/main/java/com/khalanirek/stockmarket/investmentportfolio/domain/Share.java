package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.common.ChildEntity;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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

    InvestmentPortfolioDto.InvestmentPortfolio.Share toDto() {
        return InvestmentPortfolioDto.InvestmentPortfolio.Share.builder()
                .companyId(CompanyId.of(companyId))
                .quantity(quantity)
                .build();
    }

}
