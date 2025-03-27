
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

    private static ParkingLot testParkingLot = ParkingLotFactory.createParkingLot("PL001", "Test Lot", "Test Location", "08:00 AM", "06:00 PM", 10.0);
    private static ParkingSpot testParkingSpot = ParkingSpotFactory.createParkingSpot(101, "open", "compact", testParkingLot);
    private static User testUser = UserFactory.createUser("USER001", "Test User", LocalDate.of(2000, 1, 1), "male", "555-123-4567", "test@example.com");
    private static ReservationRepository reservationRepository = ReservationRepository.getInstance();
    private static Vehicle testVehicle = VehicleFactory.createVehicle("001211", "Honda", "Civic", "black", "1F87A123456789000");
    Reservation reservation = ReservationFactory.createReservation("RES001","10:00 AM", "11:00 PM", LocalDate.of(2025,03,03),50.01, testVehicle, testParkingSpot, testUser);


    @Test
    @DisplayName("A - Test Create Reservation")
    public void testCreateReservation() {
        assertNotNull(reservationRepository.create(reservation), "Created reservation should not be null");
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
        Reservation updatedReservation1 = ReservationFactory.createReservation("RES002","09:00 AM", "11:00 PM", LocalDate.of(2025,03,03),50.0, testVehicle, testParkingSpot, testUser);
        reservationRepository.create(updatedReservation1);
        Reservation updatedReservation = ReservationFactory.createReservation("RES002","10:00 AM", "01:00 PM", LocalDate.of(2025,03,03),60.0, testVehicle, testParkingSpot, testUser);

        assert updatedReservation != null;
        Reservation updated = reservationRepository.update(updatedReservation);

        assertNotNull(updated, "Updated reservation should not be null");
        assertEquals("10:00 AM", updated.getStartTime(), "Start time should be updated");
        assertEquals(60.0, updated.getPrice(), "Price should be updated");
    }

    @Test
    @DisplayName("D - Test Get All Reservations")
    public void testGetAllReservations() {
        reservationRepository.create(reservation);
        Set<Reservation> allReservations = reservationRepository.getAll();
        assertNotNull(allReservations, "All reservations set should not be null");
        assertTrue(allReservations.size() > 0, "There should be at least one reservation");
    }

    @Test
    @DisplayName("E - Test Delete Reservation")
    public void testDeleteReservation() {
        reservationRepository.delete("RES001");
        Reservation res = reservationRepository.read("RES001");
        assertNull(res, "Deleted reservation should not be found");
    }
}
