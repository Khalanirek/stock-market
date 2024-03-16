package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.common.BaseEntity;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "investor")
class Investor extends BaseEntity<InvestorId> {

    private String name;

    private String surname;

    private UUID accountId;

    private UUID investmentPortfolioId;

    void assignAccount(AccountId accountId) {
        this.accountId = accountId.getId();
    }
    void assignInvestmentPortfolio(InvestmentPortfolioId investmentPortfolioId) {
        this.investmentPortfolioId = investmentPortfolioId.getId();
    }

    InvestorDto.Investor toDto() {
        return InvestorDto.Investor.builder()
                .id(id())
                .accountId(AccountId.of(accountId))
                .investmentPortfolioId(InvestmentPortfolioId.of(investmentPortfolioId))
                .name(name)
                .surname(surname)
                .build();
    }

    @Override
    protected InvestorId id() {
        return InvestorId.of(id);
    }

}
