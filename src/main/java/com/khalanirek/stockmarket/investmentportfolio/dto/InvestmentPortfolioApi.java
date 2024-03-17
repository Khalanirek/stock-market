package com.khalanirek.stockmarket.investmentportfolio.dto;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class InvestmentPortfolioApi {

    @Value
    @Builder
    public static class InvestmentPortfolioDetails {

        UUID id;

        UUID ownerId;

        List<Share> shares;

        @Value
        @Builder
        public static class Share {

            UUID companyId;

            long quantity;

        }

    }

}
