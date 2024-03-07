package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.company.dto.CompanyDto;
import com.khalanirek.stockmarket.company.dto.OwnerType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
@Embeddable
class Owner {

    @NotNull
    UUID ownerId;

    @NotNull
    @Enumerated(EnumType.STRING)
    OwnerType ownerType;

    CompanyDto.Company.Share.Owner toDto() {
        return CompanyDto.Company.Share.Owner.builder()
                .ownerId(ownerId)
                .ownerType(ownerType)
                .build();
    }

}
