package com.khalanirek.stockmarket.investor.dto;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public final class InvestorApi {


    @Value
    @Builder
    public static class RegisterInvestorRequest {

        String name;

        String surname;

    }
    @Value
    @Builder
    public static class InvestorDetails {

        InvestorId id;

        String name;

        String surname;

        UUID investmentPortfolioId;

        UUID accountId;

    }

}
