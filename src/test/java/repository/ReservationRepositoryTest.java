
package repository;

import domain.ParkingLot;
import domain.ParkingSpot;
import domain.Reservation;
import domain.User;
import factory.ParkingLotFactory;
import factory.ParkingSpotFactory;
import factory.UserFactory;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ReservationRepositoryTest {

    private static ParkingLot testParkingLot;
    private static ParkingSpot testParkingSpot;
    private static User testUser;
    private static ReservationRepository reservationRepository;

    @BeforeAll
    public static void setUp() {
        // Create a dummy ParkingLot using the ParkingLotFactory
        testParkingLot = ParkingLotFactory.createParkingLot("PL001", "Test Lot", "Test Location", "08:00 AM", "06:00 PM", 10.0);
        // Create a dummy ParkingSpot using the ParkingSpotFactory
        testParkingSpot = ParkingSpotFactory.createParkingSpot(101, "open", "compact", testParkingLot);
        // Create a dummy User using the UserFactory
        testUser = UserFactory.createUser("USER001", "Test User", java.time.LocalDate.of(2000, 1, 1), "male", "555-1234", "test@example.com");
        // Get the singleton instance of ReservationRepository
        reservationRepository = ReservationRepository.getInstance();
    }

    @Test
    @DisplayName("A - Test Create Reservation")
    public void testCreateReservation() {
        Reservation reservation = new Reservation.Builder()
                .setReservationID("RES001")
                .setStartTime("09:00")
                .setEndTime("11:00")
                .setDate(new Date())
                .setPrice(50.0)
                .setUser(testUser)
                .setParkingSpot(testParkingSpot)
                .build();
        Reservation created = reservationRepository.create(reservation);
        assertNotNull(created, "Created reservation should not be null");
    }

    @Test
    @DisplayName("B - Test Read Reservation")
    public void testReadReservation() {
        Reservation reservation = reservationRepository.read("RES001");
        assertNotNull(reservation, "Reservation should be found");
        assertEquals("RES001", reservation.getReservationID(), "Reservation ID should match");
    }

    @Test
    @DisplayName("C - Test Update Reservation")
    public void testUpdateReservation() {
        // Update details of the reservation
        Reservation updatedReservation = new Reservation.Builder()
                .setReservationID("RES001")
                .setStartTime("10:00")
                .setEndTime("12:00")
                .setDate(new Date())
                .setPrice(60.0)
                .setUser(testUser)
                .setParkingSpot(testParkingSpot)
                .build();
        Reservation updated = reservationRepository.update(updatedReservation);
        assertNotNull(updated, "Updated reservation should not be null");
        assertEquals("10:00", updated.getStartTime(), "Start time should be updated");
        assertEquals(60.0, updated.getPrice(), 0.01, "Price should be updated");
    }

    @Test
    @DisplayName("D - Test Get All Reservations")
    public void testGetAllReservations() {
        Set<Reservation> allReservations = reservationRepository.getAll();
        assertNotNull(allReservations, "All reservations set should not be null");
        assertTrue(allReservations.size() > 0, "There should be at least one reservation");
    }

    @Test
    @DisplayName("E - Test Delete Reservation")
    public void testDeleteReservation() {
        boolean deleted = reservationRepository.delete("RES001");
        assertTrue(deleted, "Reservation should be deleted");
        Reservation res = reservationRepository.read("RES001");
        assertNull(res, "Deleted reservation should not be found");
    }
}
