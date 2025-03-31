package main.Menu;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private final Map<String, String> utilisateurs = new HashMap<>();

    public boolean creerCompte(String username, String password) {
        if (utilisateurs.containsKey(username)) return false;
        utilisateurs.put(username, password);
        return true;
    }

    public boolean seConnecter(String username, String password) {
        return utilisateurs.containsKey(username) && utilisateurs.get(username).equals(password);
    }
}
