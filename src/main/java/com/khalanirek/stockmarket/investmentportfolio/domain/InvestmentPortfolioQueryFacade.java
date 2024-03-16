package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioDto;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InvestmentPortfolioQueryFacade {

    private final InvestmentPortfolioRepository investmentPortfolioRepository;

    public InvestmentPortfolioDto.InvestmentPortfolio findInvestmentPortfolioById(InvestmentPortfolioId id) {
        InvestmentPortfolio investmentPortfolio = investmentPortfolioRepository.findById(id.getId()).orElseThrow();
        return investmentPortfolio.toDto();
    }

}
