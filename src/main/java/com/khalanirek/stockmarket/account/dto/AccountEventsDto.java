package com.khalanirek.stockmarket.account.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@UtilityClass
public class AccountEventsDto {

    public interface AccountEvent {

        UUID getAccountId();

    }

    @Value
    @Builder
    public static class AccountCreated implements AccountEvent {

        @NonNull
        UUID accountId;

        @NonNull
        UUID ownerId;

    }

    @Value
    @Builder
    public static class FundsBlocked implements AccountEvent {

        @NonNull
        UUID accountId;

        @NonNull
        BigDecimal amount;

        @NonNull
        ZonedDateTime expirationTime;

    }

    @Value
    @Builder
    public static class FundsDeposited implements AccountEvent {

        @NonNull
        UUID accountId;

        @NonNull
        BigDecimal amount;

    }

    @Value
    @Builder
    public static class FundsWithdrew implements AccountEvent {

        @NonNull
        UUID accountId;

        @NonNull
        BigDecimal amount;

    }

}
