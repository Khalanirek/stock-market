package com.khalanirek.stockmarket.account.dto;

import com.khalanirek.stockmarket.common.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class AccountId implements Id {

    @NotNull
    UUID id;

}
