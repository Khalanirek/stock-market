package com.khalanirek.stockmarket.account.domain;

import com.khalanirek.stockmarket.account.dto.AccountEventsDto;
import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;

@UtilityClass
class AccountFactory {

    static class Domain {

        static Account createAccount(InvestorId ownerId) {
            return Account.builder()
                    .id(UUIDContext.randomUUID())
                    .ownerId(ownerId.getId())
                    .balance(BigDecimal.ZERO)
                    .fundsBlockades(new HashSet<>())
                    .build();
        }

    }

    static class EventsDto {

        static AccountEventsDto.AccountCreated toAccountCreated(Account account) {
            return AccountEventsDto.AccountCreated.builder()
                    .accountId(account.id().getId())
                    .ownerId(account.getOwnerId())
                    .build();
        }

        static AccountEventsDto.FundsBlocked toFundsBlocked(Account account, BigDecimal amount, ZonedDateTime expirationTime) {
            return AccountEventsDto.FundsBlocked.builder()
                    .accountId(account.id().getId())
                    .amount(amount)
                    .expirationTime(expirationTime)
                    .build();
        }

        static AccountEventsDto.FundsDeposited toFundsDeposited(Account account, BigDecimal amount) {
            return AccountEventsDto.FundsDeposited.builder()
                    .accountId(account.id().getId())
                    .amount(amount)
                    .build();
        }

        static AccountEventsDto.FundsWithdrew toFundsWithdrew(Account account, BigDecimal amount) {
            return AccountEventsDto.FundsWithdrew.builder()
                    .accountId(account.id().getId())
                    .amount(amount)
                    .build();
        }

    }

}
