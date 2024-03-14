package com.khalanirek.stockmarket.investor.dto;

import com.khalanirek.stockmarket.account.dto.AccountId;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public final class InvestorDto {


    @Value
    @Builder
    public static class RegisterInvestor {

        String name;

        String surname;

    }
    @Value
    @Builder
    public static class Investor {

        InvestorId id;

        String name;

        String surname;

        UUID investmentPortfolioId;

        AccountId accountId;

    }

}
