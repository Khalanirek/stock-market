package com.khalanirek.stockmarket.account.domain;

import com.khalanirek.stockmarket.account.dto.AccountDto;
import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.common.BaseEntity;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "account")
class Account extends BaseEntity<AccountId> {

    private UUID ownerId;

    @NotNull
    private BigDecimal balance;


    AccountDto.Account toDto() {
        return AccountDto.Account.builder()
                .id(id())
                .ownerId(InvestorId.of(ownerId))
                .balance(balance)
                .build();
    }

    @Override
    protected AccountId id() {
        return AccountId.of(id);
    }

}
