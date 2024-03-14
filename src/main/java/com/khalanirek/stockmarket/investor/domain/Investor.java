package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.common.BaseEntity;
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

    private UUID investmentPortfolioId;

    private UUID accountId;

    void assignAccount(AccountId accountId) {
        this.accountId = accountId.getId();
    }

    InvestorDto.Investor toDto() {
        return InvestorDto.Investor.builder()
                .id(id())
                .name(name)
                .surname(surname)
                .investmentPortfolioId(investmentPortfolioId)
                .accountId(AccountId.of(accountId))
                .build();
    }

    @Override
    protected InvestorId id() {
        return InvestorId.of(id);
    }

}
