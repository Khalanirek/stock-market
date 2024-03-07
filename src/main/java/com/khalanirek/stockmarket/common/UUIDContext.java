package com.khalanirek.stockmarket.common;

import com.google.common.annotations.VisibleForTesting;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.UUID;

@UtilityClass
public class UUIDContext {

    @VisibleForTesting
    @Setter(AccessLevel.PUBLIC)
    private static UUID fixtureUUID;

    public static UUID randomUUID() {
        return Objects.requireNonNullElseGet(fixtureUUID, UUID::randomUUID);
    }

}
