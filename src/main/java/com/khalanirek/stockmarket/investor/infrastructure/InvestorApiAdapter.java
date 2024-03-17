package com.khalanirek.stockmarket.investor.infrastructure;

import com.khalanirek.stockmarket.investor.dto.InvestorApi;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InvestorApiAdapter {

    public static class ApiToDto {

        public static InvestorDto.RegisterInvestor toRegisterInvestor(InvestorApi.RegisterInvestorRequest request) {
            return InvestorDto.RegisterInvestor.builder()
                    .name(request.getName())
                    .surname(request.getSurname())
                    .build();
        }

    }

    public static class DtoToApi {

        public static InvestorApi.InvestorDetails investorDetails(InvestorDto.Investor dto) {
            return InvestorApi.InvestorDetails.builder()
                    .id(dto.getId().getId())
                    .name(dto.getName())
                    .surname(dto.getSurname())
                    .accountId(dto.getAccountId().getId())
                    .investmentPortfolioId(dto.getInvestmentPortfolioId().getId())
                    .build();
        }

    }

}
