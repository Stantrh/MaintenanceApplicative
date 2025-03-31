package main.Menu;


import main.CalendarManager;
import main.EventPeriod;
import main.Event;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class AfficherSemaineAction implements MenuAction {
    @Override
    public boolean executer(Scanner scanner, CalendarManager calendrier, String utilisateur) {
        System.out.print("Année : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Semaine : ");
        int semaine = Integer.parseInt(scanner.nextLine());

        LocalDateTime debut = LocalDateTime.now()
                .withYear(annee)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime fin = debut.plusDays(7).minusSeconds(1);

        afficherListe(calendrier.eventsDansPeriode(new EventPeriod(debut, fin)));
        return true;
    }

    private void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) System.out.println("Aucun événement trouvé pour cette période.");
        else evenements.forEach(e -> System.out.println("- " + e.description()));
    }
}
