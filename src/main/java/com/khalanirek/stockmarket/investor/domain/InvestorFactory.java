package com.khalanirek.stockmarket.investor.domain;

import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.investor.dto.InvestorDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class InvestorFactory {

    Investor createInvestor(InvestorDto.RegisterInvestor dto) {
        return Investor.builder()
                .id(UUIDContext.randomUUID())
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
    }

}
