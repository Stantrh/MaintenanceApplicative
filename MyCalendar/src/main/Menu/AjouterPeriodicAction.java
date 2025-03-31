package main.Menu;

import main.*;
import main.Events.CommonToAll.*;
import main.Events.Periodic.EventDayFrequence;
import main.Events.Type.PeriodicEvent;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterPeriodicAction implements MenuAction {

    @Override
    public boolean executer(Scanner scanner, CalendarManager calendrier, String utilisateur) {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();

        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());

        System.out.print("Fréquence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        // Pour éviter une erreur de validation, on donne une durée fictive minimale de 1
        Event event = new PeriodicEvent(
                new EventTitle(titre),
                new EventOwner(utilisateur),
                LocalDateTime.of(annee, mois, jour, heure, minute),
                new EventDuration(1),
                new EventDayFrequence(frequence)
        );

        calendrier.ajouterEvent(event);
        System.out.println("Événement périodique ajouté.");
        return true;
    }
}

