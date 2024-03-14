package com.khalanirek.stockmarket.common;

import com.google.common.annotations.VisibleForTesting;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Collections.emptyList;

@UtilityClass
public class UUIDContext {

    @VisibleForTesting
    @Setter(AccessLevel.PUBLIC)
    private static UUID fixtureUUID;

    @VisibleForTesting
    private static List<UUID> fixtureUUIDList;

    public static void setFixtureUUIDList(List<UUID> fixtureUUIDList) {
        UUIDContext.fixtureUUIDList = new ArrayList<>(fixtureUUIDList);
    }

    public static UUID randomUUID() {
        if (!CollectionUtils.isEmpty(fixtureUUIDList)) {
            UUID uuid = fixtureUUIDList.get(0);
            fixtureUUIDList.remove(0);
            return uuid;
        }
        return Objects.requireNonNullElseGet(fixtureUUID, UUID::randomUUID);
    }

    public static void clear() {
        fixtureUUID = null;
        fixtureUUIDList = emptyList();
    }

}
