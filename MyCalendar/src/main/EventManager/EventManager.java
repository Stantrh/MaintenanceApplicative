package main.EventManager;

import main.Event;
import main.EventPeriod;
import main.Events.CommonToAll.EventId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventManager {
    private final List<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvent(Event event) {
        events.add(event);
    }

    public boolean supprimerEvent(EventId id) {
        return events.removeIf(e -> e.getEventId().equals(id));
    }

    public List<Event> getEvents() {
        return new ArrayList<>(events); // Retourne une copie pour éviter modification externe
    }

    public Optional<Event> getEventParId(EventId id) {
        return events.stream()
                .filter(e -> e.getEventId().equals(id))
                .findFirst();
    }

    public List<Event> eventsDansPeriode(EventPeriod periode) {
        return events.stream()
                .filter(e -> e.estDansPeriode(periode))
                .toList();
    }

    public boolean aUnConflit(Event event) {
        return events.stream().anyMatch(e -> e.conflictsWith(event));
    }
}

