package main.Menu;

import main.*;
import main.Events.CommonToAll.*;
import main.Events.Type.RDVPersonnelEvent;

import java.time.LocalDateTime;
import java.util.Scanner;

import main.*;
import main.Events.CommonToAll.*;
import main.Events.Type.RDVPersonnelEvent;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterRDVAction implements MenuAction {

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
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        Event event = new RDVPersonnelEvent(
                new EventTitle(titre),
                new EventOwner(utilisateur),
                LocalDateTime.of(annee, mois, jour, heure, minute),
                new EventDuration(duree)
        );

        calendrier.ajouterEvent(event);
        System.out.println("Événement ajouté.");
        return true;
    }
}

