package main.Events.Meeting;

/**
 * Lieu, pour les reunion
 */
public class EventLocation {

    private String location;

    public EventLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return location;
    }
}
