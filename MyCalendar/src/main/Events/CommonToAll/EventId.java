package main.Events.CommonToAll;
import java.util.UUID;

public final class EventId {
    private final String id;

    public EventId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventId eventId)) return false;
        return id.equals(eventId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }
}
