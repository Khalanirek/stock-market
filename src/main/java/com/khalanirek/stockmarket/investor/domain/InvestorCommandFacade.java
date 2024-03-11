package com.khalanirek.stockmarket.investor.domain;

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

    public InvestorId registerInvestor(InvestorDto.RegisterInvestor dto) {
        UUID investmentPortfolioId = UUIDContext.randomUUID(); // TODO implement createInvestmentPortfolio method in investmentportfolio context
        UUID accountId = UUIDContext.randomUUID(); // TODO implement createAccount method in account context
        Investor investor = InvestorFactory.createInvestor(dto, investmentPortfolioId, accountId);
        return investorRepository.save(investor).id();
    }

}
