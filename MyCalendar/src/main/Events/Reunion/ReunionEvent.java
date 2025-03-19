package main.Events.Reunion;

import main.Event;
import main.Events.CommonToAll.EventDuration;
import main.Events.CommonToAll.EventOwner;
import main.Events.CommonToAll.EventTitle;

import java.time.LocalDateTime;

public class ReunionEvent extends Event {
    private final EventLocation lieu;
    private final ListeParticipants participants;

    public ReunionEvent(EventTitle titre, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration duree, EventLocation lieu, ListeParticipants participants) {
        super(titre, proprietaire, dateDebut, duree);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
