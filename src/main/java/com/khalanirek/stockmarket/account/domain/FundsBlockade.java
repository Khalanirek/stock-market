package com.khalanirek.stockmarket.account.domain;

import com.khalanirek.stockmarket.common.ChildEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "funds_blockade")
class FundsBlockade extends ChildEntity {

    private BigDecimal amount;

    private ZonedDateTime expirationTime;

}
