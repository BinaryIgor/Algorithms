package control.self.igor.algorithms.model;

import java.util.concurrent.TimeUnit;

public class DurationWithUnit {

    private static final String NANOS = "nanoseconds";
    private static final String MICROS = "microseconds";
    private static final String MILLIS = "milliseconds";

    private long duration;
    private String unit;

    private DurationWithUnit(long duration, String unit) {
	this.duration = duration;
	this.unit = unit;
    }

    public static DurationWithUnit createNanos(long duration) {
	return new DurationWithUnit(duration, NANOS);
    }

    public static DurationWithUnit createMicrosFromNanos(long duration) {
	return new DurationWithUnit(TimeUnit.NANOSECONDS.toMicros(duration), MICROS);
    }

    public static DurationWithUnit createMillisFromNanos(long duration) {
	return new DurationWithUnit(TimeUnit.NANOSECONDS.toMillis(duration), MILLIS);
    }

    public long getDuration() {
	return duration;
    }

    public String getUnit() {
	return unit;
    }

}
