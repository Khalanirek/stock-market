package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.experimental.UtilityClass;

import java.util.HashSet;

@UtilityClass
class InvestmentPortfolioFactory {

    static InvestmentPortfolio createInvestmentPortfolio(InvestorId investorId) {
        return InvestmentPortfolio.builder()
                .id(UUIDContext.randomUUID())
                .ownerId(investorId.getId())
                .shares(new HashSet<>())
                .build();
    }

}
