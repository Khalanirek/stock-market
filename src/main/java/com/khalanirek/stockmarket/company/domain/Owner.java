package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.company.dto.CompanyDto;
import com.khalanirek.stockmarket.company.dto.OwnerType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@Embeddable
class Owner {

    @NotNull
    private UUID ownerId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OwnerType ownerType;

    CompanyDto.Company.Share.Owner toDto() {
        return CompanyDto.Company.Share.Owner.builder()
                .ownerId(ownerId)
                .ownerType(ownerType)
                .build();
    }

}
