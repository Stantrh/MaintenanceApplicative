import main.*;
import main.Events.Type.*;
import main.Events.CommonToAll.*;
import main.User.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalendarManagerTest {

    private CalendarManager calendar;

    @BeforeEach
    void setUp() {
        calendar = new CalendarManager();
    }

    @Test
    void testAjouterEtSupprimerEvent() {
        // GIVEN
        Event event = new RDVPersonnelEvent(
                new EventTitle("RDV Dentiste"),
                new EventOwner("alice"),
                LocalDateTime.of(2025, 4, 2, 14, 0),
                new EventDuration(60)
        );

        // WHEN
        calendar.ajouterEvent(event);
        boolean removed = calendar.supprimerEvent(event.getEventId());

        // THEN
        assertTrue(removed);
        assertTrue(calendar.eventsDansPeriode(new EventPeriod(
                LocalDateTime.of(2025, 4, 1, 0, 0),
                LocalDateTime.of(2025, 4, 3, 23, 59)
        )).isEmpty());
    }

    @Test
    void testEventsDansPeriode() {
        // GIVEN
        Event event = new RDVPersonnelEvent(
                new EventTitle("RDV ophtalmo"),
                new EventOwner("bob"),
                LocalDateTime.of(2025, 4, 5, 10, 0),
                new EventDuration(30)
        );

        calendar.ajouterEvent(event);

        // WHEN
        List<Event> results = calendar.eventsDansPeriode(new EventPeriod(
                LocalDateTime.of(2025, 4, 1, 0, 0),
                LocalDateTime.of(2025, 4, 6, 0, 0)
        ));

        // THEN
        assertEquals(1, results.size());
        assertEquals(event.getTitle(), results.get(0).getTitle());
    }

    @Test
    void testAfficherEvenementsUtilisateur() {
        // GIVEN
        User user = new User("roger");
        EventOwner roger = new EventOwner("roger");
        EventOwner autre = new EventOwner("jacques");

        calendar.ajouterEvent(new RDVPersonnelEvent(
                new EventTitle("RDV généraliste"),
                roger,
                LocalDateTime.of(2025, 4, 3, 10, 0),
                new EventDuration(15)
        ));

        calendar.ajouterEvent(new RDVPersonnelEvent(
                new EventTitle("RDV notaire"),
                autre,
                LocalDateTime.of(2025, 4, 3, 12, 0),
                new EventDuration(15)
        ));

        // WHEN
        List<Event> events = calendar.eventsDansPeriode(new EventPeriod(
                LocalDateTime.of(2025, 4, 3, 0, 0),
                LocalDateTime.of(2025, 4, 3, 23, 59)
        ));

        long countRoger = events.stream()
                .filter(e -> e.getProprietaire().getNom().equals(user.getUsername()))
                .count();

        // THEN
        assertEquals(1, countRoger);
    }
}