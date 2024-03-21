package com.khalanirek.stockmarket.order.dto;

import com.khalanirek.stockmarket.common.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class OrderId implements Id {

    @NotNull
    UUID id;

}
