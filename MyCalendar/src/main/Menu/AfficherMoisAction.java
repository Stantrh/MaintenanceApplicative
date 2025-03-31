package main.Menu;


import main.CalendarManager;
import main.EventPeriod;
import main.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

class AfficherMoisAction implements MenuAction {
    @Override
    public boolean executer(Scanner scanner, CalendarManager calendrier, String utilisateur) {
        System.out.print("Année : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois : ");
        int mois = Integer.parseInt(scanner.nextLine());

        LocalDateTime debut = LocalDateTime.of(annee, mois, 1, 0, 0);
        LocalDateTime fin = debut.plusMonths(1).minusSeconds(1);

        afficherListe(calendrier.eventsDansPeriode(new EventPeriod(debut, fin)));
        return true;
    }

    private void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) System.out.println("Aucun événement trouvé pour cette période.");
        else evenements.forEach(e -> System.out.println("- " + e.description()));
    }
}

