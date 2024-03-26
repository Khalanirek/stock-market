package com.khalanirek.stockmarket.investor.infrastructure;

import com.khalanirek.stockmarket.investor.domain.InvestorCommandFacade;
import com.khalanirek.stockmarket.investor.dto.InvestorApi;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/investors")
class InvestorCommandController {

    private final InvestorCommandFacade investorCommandFacade;

    @PostMapping
    @ResponseStatus(CREATED)
    public UUID registerInvestor(@RequestBody InvestorApi.RegisterInvestorRequest request) {
        InvestorDto.RegisterInvestor registerInvestor = InvestorApiAdapter.ApiToDto.toRegisterInvestor(request);
        return investorCommandFacade.registerInvestor(registerInvestor).getId();
    }

}
