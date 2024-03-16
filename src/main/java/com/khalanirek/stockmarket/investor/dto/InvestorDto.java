package com.khalanirek.stockmarket.investor.dto;

import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

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

        AccountId accountId;

        InvestmentPortfolioId investmentPortfolioId;

        String name;

        String surname;

    }

}
