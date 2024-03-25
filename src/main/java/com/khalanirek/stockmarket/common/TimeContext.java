package com.khalanirek.stockmarket.common;

import com.google.common.annotations.VisibleForTesting;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@UtilityClass
public class TimeContext {

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));   // Better than PostConstruct - invoked before parsing in tests
    }

    @VisibleForTesting
    @Setter(AccessLevel.PUBLIC)
    private static ZonedDateTime fixtureTime;

    public static ZonedDateTime zonedNow() {
        return Objects.requireNonNullElseGet(fixtureTime, () -> ZonedDateTime.now().withFixedOffsetZone().truncatedTo(ChronoUnit.MICROS));
    }

    public static void clear() {
        fixtureTime = null;
    }

}
