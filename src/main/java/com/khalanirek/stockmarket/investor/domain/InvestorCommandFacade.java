package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade;
import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.investmentportfolio.domain.InvestmentPortfolioCommandFacade;
import com.khalanirek.stockmarket.investmentportfolio.dto.InvestmentPortfolioId;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class InvestorCommandFacade {

    private final InvestorRepository investorRepository;
    private final AccountCommandFacade accountCommandFacade;
    private final InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade;

    public InvestorId registerInvestor(InvestorDto.RegisterInvestor dto) {
        Investor investor = InvestorFactory.createInvestor(dto);
        AccountId accountId = accountCommandFacade.createAccount(investor.id());
        InvestmentPortfolioId investmentPortfolioId = investmentPortfolioCommandFacade.createInvestmentPortfolio(investor.id());
        investor.assignInvestmentPortfolio(investmentPortfolioId);
        investor.assignAccount(accountId);
        return investorRepository.save(investor).id();
    }

}
