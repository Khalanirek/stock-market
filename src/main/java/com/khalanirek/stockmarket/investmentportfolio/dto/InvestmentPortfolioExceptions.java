package com.khalanirek.stockmarket.investmentportfolio.dto;

import com.khalanirek.stockmarket.company.dto.CompanyId;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InvestmentPortfolioExceptions {

    public static class NotEnoughShares extends RuntimeException {
        public NotEnoughShares(InvestmentPortfolioId investmentPortfolioId, CompanyId companyId) {
            super("Not enough shares of company with " + companyId + " in investment portfolio with id " + investmentPortfolioId);
        }

    }

}
