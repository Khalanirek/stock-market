package com.khalanirek.stockmarket.account.domain;

import com.khalanirek.stockmarket.account.dto.AccountDto;
import com.khalanirek.stockmarket.account.dto.AccountEventsDto;
import com.khalanirek.stockmarket.account.dto.AccountExceptions;
import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.common.BaseEntity;
import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

import static java.math.BigDecimal.ZERO;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "account")
class Account extends BaseEntity<AccountId> {

    private UUID ownerId;

    @NotNull
    private BigDecimal balance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Set<FundsBlockade> fundsBlockades;

    AccountEventsDto.FundsBlocked blockFunds(BigDecimal amount, ZonedDateTime expireAt) {
        if (getAvailableBalance().subtract(amount).compareTo(ZERO) < 0) {
            throw new AccountExceptions.NotEnoughFundsException(id());
        }
        fundsBlockades.add(FundsBlockade.builder()
                        .id(UUIDContext.randomUUID())
                        .amount(amount)
                        .expirationTime(expireAt)
                .build());
        return AccountFactory.EventsDto.toFundsBlocked(this, amount, expireAt);
    }

    AccountEventsDto.FundsDeposited depositFunds(BigDecimal amount) {
        balance = balance.add(amount);
        return AccountFactory.EventsDto.toFundsDeposited(this, amount);
    }

    AccountEventsDto.FundsWithdrew withdrawFunds(BigDecimal amount) {
        if (getAvailableBalance().subtract(amount).compareTo(ZERO) < 0) {
            throw new AccountExceptions.NotEnoughFundsException(id());
        }
        balance = balance.subtract(amount);
        return AccountFactory.EventsDto.toFundsWithdrew(this, amount);
    }

    @Transient
    BigDecimal getAvailableBalance() {
        return balance.subtract(getBlockadesSum());
    }

    @Transient
    BigDecimal getBlockadesSum() {
        return fundsBlockades.stream()
                .map(FundsBlockade::getAmount)
                .reduce(ZERO, BigDecimal::add);
    }

    AccountDto.Account toDto() {
        return AccountDto.Account.builder()
                .id(id())
                .ownerId(InvestorId.of(ownerId))
                .availableBalance(getAvailableBalance())
                .build();
    }

    @Override
    protected AccountId id() {
        return AccountId.of(id);
    }

}
