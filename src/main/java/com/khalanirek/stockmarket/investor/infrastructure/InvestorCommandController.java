package com.khalanirek.stockmarket.investor.infrastructure;

import com.khalanirek.stockmarket.investor.domain.InvestorCommandFacade;
import com.khalanirek.stockmarket.investor.dto.InvestorApi;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/investors")
class InvestorCommandController {

    private final InvestorCommandFacade investorCommandFacade;

    @PostMapping
    public UUID registerInvestor(InvestorApi.RegisterInvestorRequest request) {
        InvestorDto.RegisterInvestor registerInvestor = InvestorApiAdapter.ApiToDto.toRegisterInvestor(request);
        return investorCommandFacade.registerInvestor(registerInvestor).getId();
    }

}
