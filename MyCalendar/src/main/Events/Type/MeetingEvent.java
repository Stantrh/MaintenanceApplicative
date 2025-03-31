package main.Events.Type;

import main.Event;
import main.Events.CommonToAll.EventDuration;
import main.Events.CommonToAll.EventOwner;
import main.Events.CommonToAll.EventTitle;
import main.Events.Meeting.EventLocation;
import main.Events.Meeting.ListeParticipants;

import java.time.LocalDateTime;

public class MeetingEvent extends Event {
    private final EventLocation lieu;
    private final ListeParticipants participants;

    public MeetingEvent(EventTitle titre, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration duree, EventLocation lieu, ListeParticipants participants) {
        super(titre, proprietaire, dateDebut, duree);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
