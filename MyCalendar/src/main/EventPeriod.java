package main;

import java.time.LocalDateTime;

public class EventPeriod {
    private final LocalDateTime debut;
    private final LocalDateTime fin;

    public EventPeriod(LocalDateTime debut, LocalDateTime fin) {
        if (debut.isAfter(fin)) {
            throw new IllegalArgumentException("La date de début doit être avant la date de fin");
        }
        this.debut = debut;
        this.fin = fin;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }
}
