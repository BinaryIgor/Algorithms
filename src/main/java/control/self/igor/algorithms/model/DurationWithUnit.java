package control.self.igor.algorithms.model;

public class DurationWithUnit {

    private final static int CHANGE_UNITS_THRESHOLD = 1000;
    private long duration;
    private String unit;

    private DurationWithUnit(long duration, String unit) {
	this.duration = duration;
	this.unit = unit;
    }

    public static DurationWithUnit createFromNanos(long durationInNanos) {
	long duration;
	DurationUnit unit;
	if (durationInNanos < CHANGE_UNITS_THRESHOLD) {
	    duration = durationInNanos;
	    unit = DurationUnit.NANOS;
	} else {
	    int unitsChanges = getUnitsChanges(durationInNanos);
	    unit = DurationUnit.values()[unitsChanges];
	    duration = durationInNanos / ((long) Math.pow(CHANGE_UNITS_THRESHOLD, unitsChanges));
	}
	return new DurationWithUnit(duration, unit.value);
    }

    private static int getUnitsChanges(long durationInNanos) {
	int maximalUnitsChanges = DurationUnit.values().length - 1;
	int unitChanges = 0;
	long duration = durationInNanos;
	while (duration >= CHANGE_UNITS_THRESHOLD && unitChanges <= maximalUnitsChanges) {
	    duration /= CHANGE_UNITS_THRESHOLD;
	    ++unitChanges;
	}
	return unitChanges;
    }

    public long getDuration() {
	return duration;
    }

    public String getUnit() {
	return unit;
    }

    @Override
    public String toString() {
	return duration + " " + unit;
    }

    public enum DurationUnit {
	NANOS("nanos"), MICROS("micros"), MILLIS("millis"), SECONDS("seconds");

	private String value;

	DurationUnit(String value) {
	    this.value = value;
	}

	public String getValue() {
	    return value;
	}

    }

}
