package main;

import main.Events.Periodique.PeriodicEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public List<Event> events;

    public CalendarManager() {
        // on ajoute un event manager
        this.events = new ArrayList<Event>();
    }

    public void ajouterEvent(Event event) {
        events.add(event);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e instanceof PeriodicEvent) {
                LocalDateTime temp = e.dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays((long) ((PeriodicEvent) e).getFrequence().getDayFrequence());
                }
            } else if (!e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.getDureeMinutes().getDureeMinutes());
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.getDureeMinutes().getDureeMinutes());

        if (e1 instanceof PeriodicEvent || e2 instanceof PeriodicEvent) {
            return false; // Simplification abusive
        }

        if (e1.dateDebut.isBefore(fin2) && fin1.isAfter(e2.dateDebut)) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}