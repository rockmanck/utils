package ck.rockman.utils;

import ck.rockman.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Timing {
    private static List<Tuple<TimeUnit, String>> timeType = new ArrayList<>();
    static {
        timeType.add(new Tuple<>(TimeUnit.NANOSECONDS, " ns"));
        timeType.add(new Tuple<>(TimeUnit.MICROSECONDS, " µs"));
        timeType.add(new Tuple<>(TimeUnit.MILLISECONDS, " ms"));
        timeType.add(new Tuple<>(TimeUnit.SECONDS, " s"));
        timeType.add(new Tuple<>(TimeUnit.MINUTES, " m"));
    }

    public static double nanosTo(TimeUnit timeUnit, long value) {
        switch (timeUnit) {
            case NANOSECONDS: return value;
            case MICROSECONDS: return value / 1000D;
            case MILLISECONDS: return value / 1000_000D;
            case SECONDS: return value / 1000_000_000D;
            case MINUTES: return value / 1000_000_000D / 60;
            case HOURS: return value / 1000_000_000D / 60 / 60;
        }
        return timeUnit.convert(value, TimeUnit.NANOSECONDS);
    }

    public static String toString(long value) {
        for (Tuple<TimeUnit, String> type : timeType) {
            final double casted = nanosTo(type._1(), value);
            if (casted < 100) {
                return NumberUtils.round(casted) + type._2();
            }
        }
        return NumberUtils.round(nanosTo(TimeUnit.HOURS, value)) + " h";
    }

    private static String getStringRepresentation(long value, TimeUnit timeUnit) {
        final double micros = nanosTo(TimeUnit.MICROSECONDS, value);
        if (micros < 1000) {
            return NumberUtils.round(micros) + " µs";
        }
        return null;
    }
}
