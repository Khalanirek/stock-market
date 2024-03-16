package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.common.ChildEntity;
import com.khalanirek.stockmarket.company.dto.CompanyDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "company_share")
class CompanyShare extends ChildEntity {

    @NotNull
    private Owner owner;

    private long quantity;

    CompanyDto.Company.Share toDto() {
        return CompanyDto.Company.Share.builder()
                .owner(owner.toDto())
                .quantity(quantity)
                .build();
    }

}
