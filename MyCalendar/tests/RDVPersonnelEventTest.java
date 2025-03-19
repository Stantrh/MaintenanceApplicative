import org.junit.jupiter.api.Test;
import main.Events.CommonToAll.*;
import main.Events.RDVPersonnel.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RDVPersonnelEventTest {
    @Test
    void shouldCreateRDVPersonnelEventAndGenerateDescription() {
        // Création des objets nécessaires
        EventTitle title = new EventTitle("Dentiste");
        EventOwner owner = new EventOwner("Bob");
        LocalDateTime date = LocalDateTime.of(2025, 3, 20, 10, 30);
        EventDuration duration = new EventDuration(30);

        // Création de l'événement
        RDVPersonnelEvent event = new RDVPersonnelEvent(title, owner, date, duration);

        // Vérifications
        assertEquals("Dentiste", event.getTitle());
        assertEquals("Bob", event.getProprietaire());
        assertEquals("RDV : Dentiste à 2025-03-20T10:30", event.description());
    }
}
