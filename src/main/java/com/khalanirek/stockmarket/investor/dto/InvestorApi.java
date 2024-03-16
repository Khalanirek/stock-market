package com.khalanirek.stockmarket.investor.dto;

import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

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

        AccountId accountId;

        InvestmentPortfolioId investmentPortfolioId;

        String name;

        String surname;

    }

}
