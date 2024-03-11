package com.khalanirek.stockmarket.investor.infrastructure;

import com.khalanirek.stockmarket.investor.domain.InvestorQueryFacade;
import com.khalanirek.stockmarket.investor.dto.InvestorApi;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/investors")
class InvestorQueryController {

    private final InvestorQueryFacade investorQueryFacade;

    @GetMapping("/{investorId}")
    public InvestorApi.InvestorDetails getInvestorDetails(@PathVariable UUID investorId) {
        InvestorDto.Investor investor = investorQueryFacade.findInvestorById(InvestorId.of(investorId));
        return InvestorApiAdapter.DtoToApi.investorDetails(investor);
    }

}
