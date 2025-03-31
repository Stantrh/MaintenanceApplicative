package main.Menu;

public class MenuPrinter {

    public static void afficherMenuPrincipal(String utilisateur) {
        System.out.println("\nBonjour, " + utilisateur);
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un événement périodique");
        System.out.println("5 - Se déconnecter");
        System.out.print("Votre choix : ");
    }
}
