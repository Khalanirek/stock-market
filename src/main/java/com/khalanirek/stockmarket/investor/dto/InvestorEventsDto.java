package com.khalanirek.stockmarket.investor.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class InvestorEventsDto {

    public interface InvestorEvent {

        InvestorId getInvestorId();

    }

    @Value
    @Builder
    public static class InvestorRegisteredEvent implements InvestorEvent {

        @NonNull
        InvestorId investorId;

        @NonNull
        UUID accountId;

        @NonNull
        UUID investmentPortfolioId;

        @NonNull
        String name;

        @NonNull
        String surname;

    }

}
