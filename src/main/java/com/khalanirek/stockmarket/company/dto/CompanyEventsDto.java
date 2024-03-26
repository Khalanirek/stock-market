package com.khalanirek.stockmarket.company.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.UUID;

@UtilityClass
public class CompanyEventsDto {

    public interface CompanyEvent {

        UUID getCompanyId();

    }

    @Value
    @Builder
    public static class CompanyRegisteredEvent implements CompanyEvent {

        @NonNull
        UUID companyId;

        @NonNull
        String name;

        @NonNull
        String symbol;

        @NonNull
        BigDecimal shareCapital;

        long sharesQuantity;

    }

}
