package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.common.UUIDContext;
import com.khalanirek.stockmarket.company.dto.CompanyDto;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static com.khalanirek.stockmarket.company.dto.OwnerType.SELF;

@UtilityClass
class CompanyFactory {

    Company createCompany(CompanyDto.RegisterCompany dto) {
        UUID companyId = UUIDContext.randomUUID();
        CompanyShare selfShare = CompanyShare.builder()
                .id(UUIDContext.randomUUID())
                .owner(Owner.builder()
                        .ownerId(companyId)
                        .ownerType(SELF)
                        .build())
                .quantity(dto.getSharesQuantity())
                .build();
        Set<CompanyShare> companyShares = new HashSet<>();
        companyShares.add(selfShare);
        return Company.builder()
                .id(companyId)
                .name(dto.getName())
                .symbol(dto.getSymbol())
                .shareCapital(dto.getShareCapital())
                .shares(companyShares)
                .build();
    }

}
