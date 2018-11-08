package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Joanna Pakosh on лист., 2018
 */
public class TimeUtil {

    private TimeUtil() {}

    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);

    public static final LocalTime TIME_NOW = LocalTime.now();
    public static final LocalTime TIME_MORNING = LocalTime.of(6, 00);
    public static final LocalTime TIME_DAY = LocalTime.of(9, 00);
    public static final LocalTime TIME_EVENING = LocalTime.of(19, 00);
    public static final LocalTime TIME_NIGHT = LocalTime.of(23, 00);

    public static boolean isBetween(LocalTime value, LocalTime start, LocalTime end) {
        return value.compareTo(start) >=0 && value.compareTo(end)<=0;
    }
}
