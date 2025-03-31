package main.Menu;

import main.CalendarManager;

import java.util.Scanner;

public interface MenuAction {
    boolean executer(Scanner scanner, CalendarManager calendrier, String utilisateur);
}
