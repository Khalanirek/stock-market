package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import com.khalanirek.stockmarket.investor.dto.InvestorEventsDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class InvestorFactory {

    static class Domain {

        static Investor createInvestor(InvestorDto.RegisterInvestor dto) {
            return Investor.builder()
                    .id(UUIDContext.randomUUID())
                    .name(dto.getName())
                    .surname(dto.getSurname())
                    .build();
        }

    }

    static class EventsDto {

        static InvestorEventsDto.InvestorRegisteredEvent toInvestorRegistered(Investor investor) {
            return InvestorEventsDto.InvestorRegisteredEvent.builder()
                    .investorId(investor.id())
                    .accountId(investor.getAccountId())
                    .investmentPortfolioId(investor.getInvestmentPortfolioId())
                    .name(investor.getName())
                    .surname(investor.getSurname())
                    .build();
        }

    }

}
