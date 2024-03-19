package com.khalanirek.stockmarket.investmentportfolio.dto;

import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;
import java.util.Set;

@UtilityClass
public class InvestmentPortfolioDto {

    @Value
    @Builder
    public static class BlockShares {

        InvestmentPortfolioId investmentPortfolioId;

        Share share;

        ZonedDateTime expirationTime;

    }

    @Value
    @Builder
    public static class InvestmentPortfolio {

        InvestmentPortfolioId id;

        InvestorId ownerId;

        Set<Share> shares;

    }

    @Value
    @Builder
    public static class Share {

        CompanyId companyId;

        long quantity;

    }

}
