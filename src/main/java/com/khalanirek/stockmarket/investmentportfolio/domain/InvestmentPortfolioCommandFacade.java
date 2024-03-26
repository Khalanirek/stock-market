package com.khalanirek.stockmarket.investmentportfolio.domain;

import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Transactional
public class InvestmentPortfolioCommandFacade {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final InvestmentPortfolioRepository investmentPortfolioRepository;

    public InvestmentPortfolioId createInvestmentPortfolio(InvestorId investorId) {
        InvestmentPortfolio investmentPortfolio = InvestmentPortfolioFactory.Domain.createInvestmentPortfolio(investorId);
        investmentPortfolioRepository.save(investmentPortfolio);
        applicationEventPublisher.publishEvent(InvestmentPortfolioFactory.EventsDto.toInvestmentPortfolioCreated(investmentPortfolio));
        return investmentPortfolio.id();
    }

    public void blockShares(InvestmentPortfolioId investmentPortfolioId, CompanyId companyId, long quantity, ZonedDateTime expireAt) {
        InvestmentPortfolio investmentPortfolio = investmentPortfolioRepository.findById(investmentPortfolioId.getId()).orElseThrow();
        applicationEventPublisher.publishEvent(investmentPortfolio.blockShares(companyId, quantity, expireAt));
    }

    public void addShare(InvestmentPortfolioId investmentPortfolioId, CompanyId companyId, long quantity) {
        InvestmentPortfolio investmentPortfolio = investmentPortfolioRepository.findById(investmentPortfolioId.getId()).orElseThrow();
        applicationEventPublisher.publishEvent(investmentPortfolio.addShare(companyId, quantity));
    }

}
