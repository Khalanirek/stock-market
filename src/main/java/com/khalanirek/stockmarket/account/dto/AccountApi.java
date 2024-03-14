package com.khalanirek.stockmarket.account.dto;

import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class AccountApi {

    @Value
    @Builder
    public static class AccountDetails {

        AccountId id;

        InvestorId ownerId;

        BigDecimal balance;

    }

}
