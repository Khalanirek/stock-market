package com.khalanirek.stockmarket.investor.dto

import com.khalanirek.stockmarket.investor.dto.InvestorApi.InvestorDetails
import com.khalanirek.stockmarket.investor.dto.InvestorDto.Investor
import com.khalanirek.stockmarket.investor.dto.InvestorDto.RegisterInvestor

class InvestorFixture {

    static final String INVESTOR_API_BASE_URL = "/api/investors"
    static final UUID INVESTOR_A_ID_UUID = UUID.randomUUID()
    static final InvestorId INVESTOR_A_ID = InvestorId.of(INVESTOR_A_ID_UUID)
    static final UUID INVESTOR_A_INVESTMENT_PORTFOLIO_ID_UUID = UUID.randomUUID()
    static final UUID INVESTOR_A_ACCOUNT_ID_UUID = UUID.randomUUID()
    static final String INVESTOR_A_NAME = "Investor A name"
    static final String INVESTOR_A_SURNAME = "Investor A surname"

    static class Dto {

        static RegisterInvestor registerInvestorA() {
            return RegisterInvestor.builder()
                    .name(INVESTOR_A_NAME)
                    .surname(INVESTOR_A_SURNAME)
                    .build()
        }

        static Investor investorA() {
            return Investor.builder()
                    .id(INVESTOR_A_ID)
                    .name(INVESTOR_A_NAME)
                    .surname(INVESTOR_A_SURNAME)
                    .investmentPortfolioId(INVESTOR_A_INVESTMENT_PORTFOLIO_ID_UUID)
                    .accountId(INVESTOR_A_ACCOUNT_ID_UUID)
                    .build()
        }

    }

    static class Api {

        static InvestorApi.RegisterInvestorRequest registerInvestorARequest() {
            InvestorApi.RegisterInvestorRequest.builder()
                    .name(INVESTOR_A_NAME)
                    .surname(INVESTOR_A_SURNAME)
                    .build()
        }

        static InvestorDetails investorADetails() {
            return InvestorDetails.builder()
                    .id(INVESTOR_A_ID)
                    .name(INVESTOR_A_NAME)
                    .surname(INVESTOR_A_SURNAME)
                    .investmentPortfolioId(INVESTOR_A_INVESTMENT_PORTFOLIO_ID_UUID)
                    .accountId(INVESTOR_A_ACCOUNT_ID_UUID)
                    .build()
        }

    }

}
