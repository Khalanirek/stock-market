package com.khalanirek.stockmarket.investmentportfolio.infrastructure;

import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioApi;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class InvestmentPortfolioApiAdapter {

    static class DtoToApi {

        static InvestmentPortfolioApi.InvestmentPortfolioDetails toInvestmentPortfolioDetails(InvestmentPortfolioDto.InvestmentPortfolio dto) {
            return InvestmentPortfolioApi.InvestmentPortfolioDetails.builder()
                    .id(dto.getId().getId())
                    .ownerId(dto.getOwnerId().getId())
                    .shares(dto.getShares().stream()
                            .map(DtoToApi::toShare)
                            .toList())
                    .build();
        }

        static InvestmentPortfolioApi.InvestmentPortfolioDetails.Share toShare(InvestmentPortfolioDto.Share dto) {
            return InvestmentPortfolioApi.InvestmentPortfolioDetails.Share.builder()
                    .companyId(dto.getCompanyId().getId())
                    .availableQuantity(dto.getAvailableQuantity())
                    .blockedQuantity(dto.getBlockedQuantity())
                    .build();
        }

    }

}
