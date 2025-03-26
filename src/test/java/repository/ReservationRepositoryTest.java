
package repository;

import domain.*;
import factory.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ReservationRepositoryTest {

    private static ParkingLot testParkingLot;
    private static ParkingSpot testParkingSpot;
    private static User testUser;
    private static ReservationRepository reservationRepository;
    private static Vehicle testVehicle;

    @BeforeAll
    public static void setUp() {
        Set<User> users = new HashSet<>();
        testVehicle = VehicleFactory.createVehicle("001211", "Honda", "Civic", "black", "1F87A123456789000", users);
        // Create a dummy ParkingLot using the ParkingLotFactory
        testParkingLot = ParkingLotFactory.createParkingLot("PL001", "Test Lot", "Test Location", "08:00 AM", "06:00 PM", 10.0);
        // Create a dummy ParkingSpot using the ParkingSpotFactory
        testParkingSpot = ParkingSpotFactory.createParkingSpot(101, "open", "compact", testParkingLot);
        // Create a dummy User using the UserFactory
        testUser = UserFactory.createUser("USER001", "Test User", LocalDate.of(2000, 1, 1), "male", "555-123-4567", "test@example.com");
        // Get the singleton instance of ReservationRepository
        reservationRepository = ReservationRepository.getInstance();

        Reservation reservation = ReservationFactory.createReservation("RES001","09:00", "11:00", LocalDate.of(2025,03,03),50.01, testVehicle, testParkingSpot, testUser);

    }

    @Test
    @DisplayName("A - Test Create Reservation")
    public void testCreateReservation() {
        Reservation reservation = ReservationFactory.createReservation("RES001","09:00", "11:00", LocalDate.of(2025,03,03),50.01, testVehicle, testParkingSpot, testUser);
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
        Reservation updatedReservation = ReservationFactory.createReservation("RES001","10:00", "01:00", LocalDate.of(2025,03,03),60.0, testVehicle, testParkingSpot, testUser);

        assert updatedReservation != null;
        Reservation updated = reservationRepository.update(updatedReservation);
        assertNotNull(updated, "Updated reservation should not be null");
        assertEquals("10:00", updated.getStartTime(), "Start time should be updated");
        assertEquals(60.0, updated.getPrice(), "Price should be updated");
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
