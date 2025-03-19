import org.junit.jupiter.api.Test;
import main.Events.CommonToAll.*;
import main.Events.Reunion.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReunionEventTest {
    @Test
    void shouldCreateReunionEventAndGenerateDescription() {
        // Création des objets nécessaires
        EventTitle title = new EventTitle("Réunion Sécurité");
        EventOwner owner = new EventOwner("Alice");
        LocalDateTime date = LocalDateTime.of(2025, 3, 19, 14, 0);
        EventDuration duration = new EventDuration(60);
        EventLocation location = new EventLocation("Salle A");
        ListeParticipants participants = new ListeParticipants();
        participants.add("Bob");
        participants.add("Charlie");

        // Création de l'événement
        ReunionEvent event = new ReunionEvent(title, owner, date, duration, location, participants);

        // Vérifications
        assertEquals("Réunion Sécurité", event.getTitle());
        assertEquals("Alice", event.getProprietaire());
        assertEquals("Salle A", location.toString());
        assertEquals("Bob, Charlie", participants.toString());
        assertEquals("Réunion : Réunion Sécurité à Salle A avec Bob, Charlie", event.description());
    }
}
