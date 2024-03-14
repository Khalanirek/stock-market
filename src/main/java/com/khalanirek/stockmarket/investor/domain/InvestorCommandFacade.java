package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade;
import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Transactional
public class InvestorCommandFacade {

    private final InvestorRepository investorRepository;
    private final AccountCommandFacade accountCommandFacade;

    public InvestorId registerInvestor(InvestorDto.RegisterInvestor dto) {
        UUID investmentPortfolioId = UUIDContext.randomUUID(); // TODO implement createInvestmentPortfolio method in investmentportfolio context
        Investor investor = InvestorFactory.createInvestor(dto, investmentPortfolioId);
        AccountId accountId = accountCommandFacade.createAccount(investor.id());
        investor.assignAccount(accountId);
        return investorRepository.save(investor).id();
    }

}
