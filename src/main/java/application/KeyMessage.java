package application;

/**
 * Created by Joanna Pakosh on лист., 2018
 */
public enum KeyMessage {
    MORNING("morning"),
    DAY("day"),
    EVENING("evening"),
    NIGHT("night");

    private final String partOfDay;

    KeyMessage(String partOfDay) {
        this.partOfDay = partOfDay;
    }

    public String getPartOfDay() {
        return partOfDay;
    }

    @Override
    public String toString() {
        return partOfDay;
    }
}