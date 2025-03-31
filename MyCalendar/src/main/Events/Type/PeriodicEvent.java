package main.Events.Type;

import main.Event;
import main.EventPeriod;
import main.Events.CommonToAll.EventDuration;
import main.Events.CommonToAll.EventOwner;
import main.Events.CommonToAll.EventTitle;
import main.Events.Periodic.EventDayFrequence;

import java.time.LocalDateTime;

public class PeriodicEvent extends Event {
    private final EventDayFrequence frequence;

    public PeriodicEvent(EventTitle titre, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration duree, EventDayFrequence frequence) {
        super(titre, proprietaire, dateDebut, duree); // Durée inutile pour un périodique
        this.frequence = frequence;
    }


    public EventDayFrequence getFrequence() {
        return frequence;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title + " tous les " + frequence + " jours";
    }


    @Override
    public boolean estDansPeriode(EventPeriod periode) {
        LocalDateTime occurrence = dateDebut;
        while (occurrence.isBefore(periode.getFin())) {
            LocalDateTime finOccurrence = occurrence.plusMinutes(dureeMinutes.getDureeMinutes());
            if (!finOccurrence.isBefore(periode.getDebut()) && !occurrence.isAfter(periode.getFin())) {
                return true;
            }
            occurrence = occurrence.plusDays(frequence.getDayFrequence());
        }
        return false;
    }

}
