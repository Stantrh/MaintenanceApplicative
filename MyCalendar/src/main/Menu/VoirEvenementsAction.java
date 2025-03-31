package main.Menu;

import main.CalendarManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VoirEvenementsAction implements MenuAction {
    private final Map<String, MenuAction> visualisationActions = new HashMap<>();

    public VoirEvenementsAction() {
        visualisationActions.put("1", new AfficherTousEvenementsAction());
        visualisationActions.put("2", new AfficherMoisAction());
        visualisationActions.put("3", new AfficherSemaineAction());
        visualisationActions.put("4", new AfficherJourAction());
    }

    @Override
    public boolean executer(Scanner scanner, CalendarManager calendrier, String utilisateur) {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS");
        System.out.println("3 - d'une SEMAINE");
        System.out.println("4 - d'un JOUR");
        System.out.println("5 - Retour");
        System.out.print("Votre choix : ");

        String choix = scanner.nextLine();
        MenuAction action = visualisationActions.get(choix);
        if (action != null) {
            return action.executer(scanner, calendrier, utilisateur);
        }
        return true;
    }
}
