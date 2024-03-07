package com.khalanirek.stockmarket.company.dto;

import com.khalanirek.stockmarket.common.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class CompanyId implements Id { // TODO Check how to Serialize it with Jackson

    @NotNull
    UUID id;

}
