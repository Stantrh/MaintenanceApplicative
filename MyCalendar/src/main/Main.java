package main;

import main.Menu.*;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        String utilisateur = null;
        boolean continuer = true;

        Map<String, MenuAction> actions = Map.of(
                "1", new VoirEvenementsAction(),
                "2", new AjouterRDVAction(),
                "3", new AjouterReunionAction(),
                "4", new AjouterPeriodicAction()
        );

        UserManager userManager = new UserManager();

        while (true) {
            if (utilisateur == null) {
                afficherBienvenue();
                System.out.println("1 - Se connecter\n2 - Créer un compte\nChoix : ");
                String choix = scanner.nextLine();

                if (choix.equals("1")) {
                    System.out.print("Nom d'utilisateur: ");
                    String login = scanner.nextLine();
                    System.out.print("Mot de passe: ");
                    String motDePasse = scanner.nextLine();

                    if (userManager.seConnecter(login, motDePasse)) {
                        utilisateur = login;
                        System.out.println("\nConnexion réussie !");
                        continue;
                    } else {
                        System.out.println("Identifiants incorrects.");
                    }
                }
                else if (choix.equals("2")) {
                    System.out.print("Nom d'utilisateur: ");
                    String tentativeUser = scanner.nextLine();
                    System.out.print("Mot de passe: ");
                    String mdp = scanner.nextLine();
                    System.out.print("Répéter mot de passe: ");
                    if (scanner.nextLine().equals(mdp)) {
                        if (userManager.creerCompte(tentativeUser, mdp)) {
                            utilisateur = tentativeUser;
                            System.out.println("\nCompte créé avec succès ! Bonjour, " + utilisateur);
                        } else {
                            System.out.println("Ce nom d'utilisateur existe déjà.");
                        }
                    } else {
                        System.out.println("Les mots de passe ne correspondent pas...");
                    }
                }
            }

            while (continuer && utilisateur != null) {
                System.out.println("\nBonjour, " + utilisateur);
                System.out.println("1 - Voir les événements\n2 - Ajouter un rendez-vous perso\n3 - Ajouter une réunion\n4 - Ajouter un événement périodique\n5 - Se déconnecter");
                System.out.print("Votre choix : ");
                String choix = scanner.nextLine();

                if (actions.containsKey(choix)) {
                    actions.get(choix).executer(scanner, calendar, utilisateur);
                } else {
                    System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                    continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");
                    utilisateur = null;
                }
            }
        }
    }

    private static void afficherBienvenue() {
        System.out.println("  _____         _                   _                __  __");
        System.out.println(" / ____|       | |                 | |              |  \\/  |");
        System.out.println("| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
        System.out.println("| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
        System.out.println("| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
        System.out.println(" \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
        System.out.println("                                                                                   __/ |");
        System.out.println("                                                                                  |___/");
    }
}
