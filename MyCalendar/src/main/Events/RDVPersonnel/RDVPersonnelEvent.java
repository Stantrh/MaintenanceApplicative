package main.Events.RDVPersonnel;

import main.Event;
import main.Events.CommonToAll.EventDuration;
import main.Events.CommonToAll.EventOwner;
import main.Events.CommonToAll.EventTitle;

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
