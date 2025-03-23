//package repository;
//
//public class ReservationRepositoryTest extends RuntimeException {
//    public ReservationRepositoryTest(String message) {
//        super(message);
//    }
//}
package repository;

import domain.ParkingSpot;
import domain.Reservation;
import domain.User;
import factory.ParkingSpotFactory;
import factory.ReservationFactory;
import factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRepositoryTest {

    private ReservationRepository repository;
    private Reservation testReservation;
    private User testUser;
    private ParkingSpot testParkingSpot;

    @BeforeEach
    void setUp() {
        repository = ReservationRepository.getInstance();

        // Clean repository
        for (Reservation r : repository.getAll()) {
            repository.delete(r.getReservationID());
        }

        // Create test objects
        testUser = UserFactory.createUser("John", "Doe", "john@example.com", "password123", "0123456789");
        testParkingSpot = ParkingSpotFactory.createParkingSpot("A1", "Regular", "open", 10.0);

        testReservation = ReservationFactory.createReservation(
                testUser,
                null, // No vehicle for now
                testParkingSpot,
                new Date(),
                "09:00",
                "11:00",
                20.0
        );
    }

    @Test
    void create() {
        // When
        Reservation created = repository.create(testReservation);

        // Then
        assertNotNull(created);
        assertEquals(testReservation.getReservationID(), created.getReservationID());
    }

    @Test
    void read() {
        // Given
        repository.create(testReservation);

        // When
        Reservation found = repository.read(testReservation.getReservationID());

        // Then
        assertNotNull(found);
        assertEquals(testReservation.getReservationID(), found.getReservationID());
        assertEquals(testReservation.getStartTime(), found.getStartTime());
        assertEquals(testReservation.getEndTime(), found.getEndTime());
    }

    @Test
    void update() {
        // Given
        repository.create(testReservation);
        String newStartTime = "10:00";
        testReservation.setStartTime(newStartTime);

        // When
        Reservation updated = repository.update(testReservation);

        // Then
        assertNotNull(updated);
        assertEquals(newStartTime, updated.getStartTime());

        // Verify the update was persisted
        Reservation fromRepo = repository.read(testReservation.getReservationID());
        assertEquals(newStartTime, fromRepo.getStartTime());
    }

    @Test
    void delete() {
        // Given
        repository.create(testReservation);

        // When
        boolean deleted = repository.delete(testReservation.getReservationID());

        // Then
        assertTrue(deleted);
        assertNull(repository.read(testReservation.getReservationID()));
    }

    @Test
    void getAll() {
        // Given
        repository.create(testReservation);

        // Create another reservation
        Reservation anotherReservation = ReservationFactory.createReservation(
                testUser,
                null,
                testParkingSpot,
                new Date(),
                "13:00",
                "15:00",
                20.0
        );
        repository.create(anotherReservation);

        // When
        Set<Reservation> allReservations = repository.getAll();

        // Then
        assertEquals(2, allReservations.size());
        assertTrue(allReservations.contains(testReservation));
        assertTrue(allReservations.contains(anotherReservation));
    }

    @Test
    void createNullReservation() {
        // When
        Reservation created = repository.create(null);

        // Then
        assertNull(created);
    }

    @Test
    void readNonExistent() {
        // When
        Reservation found = repository.read("non-existent-id");

        // Then
        assertNull(found);
    }

    @Test
    void updateNonExistent() {
        // Given
        Reservation nonExistentReservation = ReservationFactory.createReservation(
                testUser,
                null,
                testParkingSpot,
                new Date(),
                "16:00",
                "18:00",
                20.0
        );

        // When
        Reservation updated = repository.update(nonExistentReservation);

        // Then
        assertNull(updated);
    }

    @Test
    void deleteNonExistent() {
        // When
        boolean deleted = repository.delete("non-existent-id");

        // Then
        assertFalse(deleted);
    }
}