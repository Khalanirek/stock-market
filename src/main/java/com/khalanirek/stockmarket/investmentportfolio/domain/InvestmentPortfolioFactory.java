package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioEventsDto;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;
import java.util.HashSet;

@UtilityClass
class InvestmentPortfolioFactory {

    static class Domain {

        static InvestmentPortfolio createInvestmentPortfolio(InvestorId investorId) {
            return InvestmentPortfolio.builder()
                    .id(UUIDContext.randomUUID())
                    .ownerId(investorId.getId())
                    .shares(new HashSet<>())
                    .build();
        }

        static Share createShare(CompanyId companyId) {
            return Share.builder()
                    .id(UUIDContext.randomUUID())
                    .companyId(companyId.getId())
                    .shareBlockades(new HashSet<>())
                    .build();
        }

    }

    static class EventsDto {

        static InvestmentPortfolioEventsDto.InvestmentPortfolioCreated toInvestmentPortfolioCreated(InvestmentPortfolio investmentPortfolio) {
            return InvestmentPortfolioEventsDto.InvestmentPortfolioCreated.builder()
                    .investmentPortfolioId(investmentPortfolio.id().getId())
                    .build();
        }

        static InvestmentPortfolioEventsDto.ShareBlocked toShareBlocked(InvestmentPortfolio investmentPortfolio,
                                                                        CompanyId companyId,
                                                                        long quantity,
                                                                        ZonedDateTime expirationTime) {
            return InvestmentPortfolioEventsDto.ShareBlocked.builder()
                    .investmentPortfolioId(investmentPortfolio.id().getId())
                    .companyId(companyId.getId())
                    .quantity(quantity)
                    .expirationTime(expirationTime)
                    .build();
        }

        static InvestmentPortfolioEventsDto.ShareAdded toShareAdded(InvestmentPortfolio investmentPortfolio,
                                                                    CompanyId companyId,
                                                                    long quantity) {
            return InvestmentPortfolioEventsDto.ShareAdded.builder()
                    .investmentPortfolioId(investmentPortfolio.id().getId())
                    .companyId(companyId.getId())
                    .quantity(quantity)
                    .build();
        }

    }

}
