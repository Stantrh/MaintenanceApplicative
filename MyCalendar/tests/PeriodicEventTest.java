import org.junit.jupiter.api.Test;
import main.Events.CommonToAll.*;
import main.Events.Periodique.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PeriodicEventTest {
    @Test
    void shouldCreatePeriodicEventAndGenerateDescription() {
        // Création des objets nécessaires
        EventTitle title = new EventTitle("Cours de Yoga");
        EventOwner owner = new EventOwner("Charlie");
        LocalDateTime date = LocalDateTime.of(2025, 3, 21, 18, 0);
        EventDuration duration = new EventDuration(15);
        EventDayFrequence frequence = new EventDayFrequence(7);

        // Création de l'événement
        PeriodicEvent event = new PeriodicEvent(title, owner, date, duration, frequence);

        // Vérifications
//        assertEquals("Cours de Yoga", event.getTitle());
        assertEquals("Charlie", event.getProprietaire());
        assertEquals("Événement périodique : Cours de Yoga tous les 7 jours", event.description());
    }
}
