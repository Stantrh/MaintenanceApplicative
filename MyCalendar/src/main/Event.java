package main;

import main.Events.CommonToAll.EventDuration;
import main.Events.CommonToAll.EventOwner;
import main.Events.CommonToAll.EventTitle;

import java.time.LocalDateTime;

public abstract class Event {    // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"    protected final EventTitle title;
    protected final EventTitle title;
    protected final EventOwner proprietaire;
    protected final LocalDateTime dateDebut; // pas besoin de modifier
    protected final EventDuration dureeMinutes;

    public Event(EventTitle title, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }


    public abstract String description();


    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public EventDuration getDureeMinutes() {
        return dureeMinutes;
    }

    public EventOwner getProprietaire() {
        return proprietaire;
    }

    public EventTitle getTitle() {
        return title;
    }


}