package main;

import main.Events.EventDuration;
import main.Events.EventOwner;
import main.Events.EventTitle;

import java.time.LocalDateTime;

public abstract class Event {    // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"    protected final EventTitle title;
    public EventTitle title;
    public EventOwner proprietaire;
    public LocalDateTime dateDebut; // pas besoin de modifier
    public EventDuration dureeMinutes;

    public Event(EventTitle title, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();
}