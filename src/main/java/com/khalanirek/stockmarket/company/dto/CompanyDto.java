package com.khalanirek.stockmarket.company.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@UtilityClass
public final class CompanyDto {

    @Value
    @Builder
    public static class RegisterCompany {

        @NonNull
        String name;

        @NonNull
        String symbol;

        @NonNull
        BigDecimal shareCapital;

        long sharesQuantity;

    }

    @Value
    @Builder
    public static class Company {

        @NonNull
        String name;

        @NonNull
        String symbol;

        @NonNull
        BigDecimal shareCapital;

        long sharesQuantity;

        Set<Share> shares;

        @Value
        @Builder
        public static class Share {

            @NonNull
            Owner owner;

            long quantity;

            @Value
            @Builder
            public static class Owner {

                @NonNull
                UUID ownerId;

                @NonNull
                @Enumerated(EnumType.STRING)
                OwnerType ownerType;

            }

        }

    }


}
