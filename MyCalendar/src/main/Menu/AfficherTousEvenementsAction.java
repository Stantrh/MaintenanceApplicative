package main.Menu;

import main.CalendarManager;

import java.util.Scanner;

public class AfficherTousEvenementsAction implements MenuAction {
    @Override
    public boolean executer(Scanner scanner, CalendarManager calendrier, String utilisateur) {
        calendrier.afficherEvenements();
        return true;
    }
}