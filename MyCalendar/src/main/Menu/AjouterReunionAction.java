package main.Menu;

import main.*;
import main.Events.CommonToAll.*;
import main.Events.Meeting.*;
import main.Events.Type.MeetingEvent;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterReunionAction implements MenuAction {

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

        System.out.print("Lieu : ");
        String lieu = scanner.nextLine();

        ListeParticipants participants = new ListeParticipants();
        System.out.println("Ajouter un participant ? (oui / non)");

        while (scanner.nextLine().equalsIgnoreCase("oui")) {
            System.out.print("Participants actuels : " + participants + "\nAjouter : ");
            String participant = scanner.nextLine();
            participants.add(participant);
            System.out.println("Ajouter un autre participant ? (oui / non)");
        }

        Event event = new MeetingEvent(
                new EventTitle(titre),
                new EventOwner(utilisateur),
                LocalDateTime.of(annee, mois, jour, heure, minute),
                new EventDuration(duree),
                new EventLocation(lieu),
                participants
        );

        calendrier.ajouterEvent(event);
        System.out.println("Réunion ajoutée.");
        return true;
    }
}
