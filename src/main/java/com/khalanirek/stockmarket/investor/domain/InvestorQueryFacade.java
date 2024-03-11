package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InvestorQueryFacade {

    private final InvestorRepository investorRepository;

    public InvestorDto.Investor findInvestorById(InvestorId id) {
        return investorRepository.findById(id.getId()).orElseThrow().toDto();
    }

}
