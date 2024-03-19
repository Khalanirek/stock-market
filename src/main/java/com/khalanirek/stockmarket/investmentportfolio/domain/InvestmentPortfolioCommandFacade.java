package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Transactional
public class InvestmentPortfolioCommandFacade {

    private final InvestmentPortfolioRepository investmentPortfolioRepository;

    public InvestmentPortfolioId createInvestmentPortfolio(InvestorId investorId) {
        InvestmentPortfolio investmentPortfolio = InvestmentPortfolioFactory.createInvestmentPortfolio(investorId);
        return investmentPortfolioRepository.save(investmentPortfolio).id();
    }

    public void blockShares(InvestmentPortfolioId investmentPortfolioId, CompanyId companyId, long quantity, ZonedDateTime expireAt) {
        InvestmentPortfolio investmentPortfolio = investmentPortfolioRepository.findById(investmentPortfolioId.getId()).orElseThrow();
        investmentPortfolio.blockShares(companyId, quantity, expireAt);
    }

    public void addShare(InvestmentPortfolioId investmentPortfolioId, CompanyId companyId, long quantity) {
        InvestmentPortfolio investmentPortfolio = investmentPortfolioRepository.findById(investmentPortfolioId.getId()).orElseThrow();
        investmentPortfolio.addShare(companyId, quantity);
    }

}
