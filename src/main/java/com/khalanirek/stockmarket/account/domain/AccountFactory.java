package com.khalanirek.stockmarket.account.domain;

import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
class AccountFactory {

    Account createAccount(InvestorId ownerId) {
        return Account.builder()
                .id(UUIDContext.randomUUID())
                .ownerId(ownerId.getId())
                .balance(BigDecimal.ZERO)
                .build();
    }

}
