package com.khalanirek.stockmarket.common;

import com.google.common.annotations.VisibleForTesting;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Collections.emptyList;

@UtilityClass
public class TimeContext {

    @VisibleForTesting
    @Setter(AccessLevel.PUBLIC)
    private static ZonedDateTime fixtureTime;

    public static ZonedDateTime zonedNow() {
        return Objects.requireNonNullElseGet(fixtureTime, ZonedDateTime::now);
    }

    public static void clear() {
        fixtureTime = null;
    }

}
