package main;

import main.EventManager.EventManager;
import main.Events.Type.PeriodicEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import main.Events.CommonToAll.EventId;
import main.User.User;

public class CalendarManager {
    private final EventManager eventManager;

    public CalendarManager() {
        this.eventManager = new EventManager();
    }

    public void ajouterEvent(Event event) {
        eventManager.ajouterEvent(event);
    }

    public boolean supprimerEvent(EventId id) {
        return eventManager.supprimerEvent(id);
    }

    public List<Event> eventsDansPeriode(EventPeriod periode) {
        return eventManager.eventsDansPeriode(periode);
    }

    public void afficherEvenements() {
        eventManager.getEvents().forEach(e -> System.out.println(e.description()));
    }

    public void afficherEvenementsUtilisateur(User user) {
        eventManager.getEvents().stream()
                .filter(e -> e.getProprietaire().getNom().equals(user.getUsername()))
                .forEach(e -> System.out.println(e.description()));
    }
}