package com.khalanirek.stockmarket.company.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@UtilityClass
public final class CompanyApi {

    @Value
    @Builder
    public static class RegisterCompanyRequest {

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
    public static class CompanyDetails {

        @NonNull
        String name;

        @NonNull
        String symbol;

        @NonNull
        BigDecimal shareCapital;

        long sharesQuantity;

        List<Share> shares;

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
