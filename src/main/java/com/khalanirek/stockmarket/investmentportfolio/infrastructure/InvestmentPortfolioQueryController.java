package com.khalanirek.stockmarket.investmentportfolio.infrastructure;

import com.khalanirek.stockmarket.investmentportfolio.domain.InvestmentPortfolioQueryFacade;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioApi;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/investment-portfolios")
class InvestmentPortfolioQueryController {

    private final InvestmentPortfolioQueryFacade investmentPortfolioQueryFacade;

    @GetMapping("/{investmentPortfolioId}")
    public InvestmentPortfolioApi.InvestmentPortfolioDetails getInvestmentPortfolioDetails(@PathVariable UUID investmentPortfolioId) {
        InvestmentPortfolioDto.InvestmentPortfolio investmentPortfolio =
                investmentPortfolioQueryFacade.findInvestmentPortfolioById(InvestmentPortfolioId.of(investmentPortfolioId));
        return InvestmentPortfolioApiAdapter.DtoToApi.toInvestmentPortfolioDetails(investmentPortfolio);
    }

}
