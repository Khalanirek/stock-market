package com.khalanirek.stockmarket.account.dto;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.UUID;

@UtilityClass
public class AccountApi {

    @Value
    @Builder
    public static class AccountDetails {

        UUID id;

        UUID ownerId;

        BigDecimal balance;

    }

}
