package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class InvestmentPortfolioCommandFacade {

    private final InvestmentPortfolioRepository investmentPortfolioRepository;

    public InvestmentPortfolioId createInvestmentPortfolio(InvestorId investorId) {
        InvestmentPortfolio investmentPortfolio = InvestmentPortfolioFactory.createInvestmentPortfolio(investorId);
        return investmentPortfolioRepository.save(investmentPortfolio).id();
    }

}
