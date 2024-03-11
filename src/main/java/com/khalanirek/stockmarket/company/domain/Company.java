package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.common.BaseEntity;
import com.khalanirek.stockmarket.company.dto.CompanyDto;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "company")
class Company extends BaseEntity<CompanyId> {

    @NotNull
    private String name;

    @NotNull
    private String symbol;

    @NotNull
    private BigDecimal shareCapital;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private Set<Share> shares;

    @Transient
    long getSharesQuantity() {
        return shares.stream()
                .mapToLong(Share::getQuantity)
                .sum();
    }

    CompanyDto.Company toDto() {
        return CompanyDto.Company.builder()
                .id(id())
                .name(name)
                .symbol(symbol)
                .shareCapital(shareCapital)
                .sharesQuantity(getSharesQuantity())
                .shares(shares.stream()
                        .map(Share::toDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    @Override
    protected CompanyId id() {
        return CompanyId.of(id);
    }
}
