package main.Events.Periodique;

import main.Event;
import main.Events.EventDuration;
import main.Events.EventOwner;
import main.Events.EventTitle;

import java.time.LocalDateTime;

public class PeriodicEvent extends Event {
    private final EventDayFrequence frequence;

    public PeriodicEvent(EventTitle titre, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration duree, EventDayFrequence frequence) {
        super(titre, proprietaire, dateDebut, duree); // Durée inutile pour un périodique
        this.frequence = frequence;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title + " tous les " + frequence + " jours";
    }
}
