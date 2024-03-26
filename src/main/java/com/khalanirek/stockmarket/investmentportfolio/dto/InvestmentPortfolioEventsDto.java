package com.khalanirek.stockmarket.investmentportfolio.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;
import java.util.UUID;

@UtilityClass
public class InvestmentPortfolioEventsDto {

    public interface InvestmentPortfolioEvent {

        UUID getInvestmentPortfolioId();

    }

    @Value
    @Builder
    public static class InvestmentPortfolioCreated implements InvestmentPortfolioEvent {

        @NonNull
        UUID investmentPortfolioId;

    }

    @Value
    @Builder
    public static class ShareBlocked implements InvestmentPortfolioEvent {

        @NonNull
        UUID investmentPortfolioId;

        @NonNull
        UUID companyId;

        long quantity;

        @NonNull
        ZonedDateTime expirationTime;

    }

    @Value
    @Builder
    public static class ShareAdded implements InvestmentPortfolioEvent {

        @NonNull
        UUID investmentPortfolioId;

        @NonNull
        UUID companyId;

        long quantity;

    }

}
