package com.khalanirek.stockmarket.investmentportfolio.dto;

import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class InvestmentPortfolioApi {

    @Value
    @Builder
    public static class InvestmentPortfolioDetails {

        InvestmentPortfolioId id;

        InvestorId ownerId;

        List<Share> shares;

        @Value
        @Builder
        public static class Share {

            CompanyId companyId;

            long quantity;

        }

    }

}
