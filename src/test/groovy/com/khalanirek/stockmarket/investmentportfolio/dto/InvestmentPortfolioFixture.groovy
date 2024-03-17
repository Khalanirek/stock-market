package com.khalanirek.stockmarket.investmentportfolio.dto

import com.khalanirek.stockmarket.investor.dto.InvestorId

class InvestmentPortfolioFixture {

    static final String INVESTMENT_PORTFOLIO_API_BASE_URL = "/api/investment-portfolios"
    static final UUID INVESTMENT_PORTFOLIO_A_ID_UUID = UUID.randomUUID()
    static final InvestmentPortfolioId INVESTMENT_PORTFOLIO_A_ID = InvestmentPortfolioId.of(INVESTMENT_PORTFOLIO_A_ID_UUID)
    static final UUID INVESTMENT_PORTFOLIO_A_OWNER_ID_UUID = UUID.randomUUID()
    static final InvestorId INVESTMENT_PORTFOLIO_A_OWNER_ID = InvestorId.of(INVESTMENT_PORTFOLIO_A_OWNER_ID_UUID)

    static class Dto {

        static InvestmentPortfolioDto.InvestmentPortfolio newInvestmentPortfolioA() {
            return InvestmentPortfolioDto.InvestmentPortfolio.builder()
                    .id(INVESTMENT_PORTFOLIO_A_ID)
                    .ownerId(INVESTMENT_PORTFOLIO_A_OWNER_ID)
                    .shares(Set.of())
                    .build()
        }

    }

    static class Api {

        static InvestmentPortfolioApi.InvestmentPortfolioDetails newInvestmentPortfolioADetails() {
            return InvestmentPortfolioApi.InvestmentPortfolioDetails.builder()
                    .id(INVESTMENT_PORTFOLIO_A_ID_UUID)
                    .ownerId(INVESTMENT_PORTFOLIO_A_OWNER_ID_UUID)
                    .shares(List.of())
                    .build()
        }

    }

}
