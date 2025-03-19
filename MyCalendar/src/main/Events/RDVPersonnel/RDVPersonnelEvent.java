package main.Events.RDVPersonnel;

import main.Event;
import main.Events.EventDuration;
import main.Events.EventOwner;
import main.Events.EventTitle;

import java.time.LocalDateTime;

public class RDVPersonnelEvent extends Event {
    public RDVPersonnelEvent(EventTitle title, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration duree) {
        super(title, proprietaire, dateDebut, duree);

    }

    @Override
    public String description() {
        return "RDV : " + title + " à " + dateDebut;
    }
}
