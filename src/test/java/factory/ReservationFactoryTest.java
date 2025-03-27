package factory;

import domain.ParkingLot;
import domain.ParkingSpot;
import domain.Reservation;
import domain.User;
import domain.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationFactoryTest {

    private User testUser = UserFactory.createUser("811", "Sean Bailey", LocalDate.of(2001, 9,9), "male", "081-222-1111", "sean@gmail.com");
    private Vehicle testVehicle = VehicleFactory.createVehicle("001211", "Honda", "Civic", "black", "1F87A123456789000");
    private ParkingLot testParkingLot = ParkingLotFactory.createParkingLot("201", "OpenSeason", "12 Avenue CPUT", 12.25);
    private ParkingSpot testParkingSpot = ParkingSpotFactory.createParkingSpot(111, "open", "compact", testParkingLot);


    @Test
    @DisplayName("Reservation Object with all attributes")
    void createReservation() {
        Reservation reservation = ReservationFactory.createReservation("12345", "09:00 AM", "10:00 AM", LocalDate.of(2025, 04,01), 10.50, testVehicle, testParkingSpot, testUser);
        assertNotNull(reservation, "should not be null");
        assertInstanceOf(Reservation.class, reservation, "should be an instance of reservation class");
        assertEquals("12345", reservation.getReservationID());
    }

    @Test
    @DisplayName("Reservation Object, no Vehicle")
    void testCreateReservation() {
        Reservation reservation = ReservationFactory.createReservation("81922", "09:00 AM", "10:00 PM", LocalDate.of(2025, 04,01), 10.50, testParkingSpot, testUser);
        assertNotNull(reservation, "should not be null");
        assertInstanceOf(Reservation.class, reservation, "should be an instance of reservation class");
        assertEquals("81922", reservation.getReservationID());
        assertNull(reservation.getVehicle(), "should be null");
    }

    @Test
    @DisplayName("Reservation Object, no user")
    void testCreateReservation1() {
        Reservation reservation = ReservationFactory.createReservation("12039", "09:00 PM", "10:00 AM", LocalDate.of(2025, 04,01), 10.50, testVehicle, testParkingSpot);
        assertNotNull(reservation, "should not be null");
        assertInstanceOf(Reservation.class, reservation, "should be an instance of reservation class");
        assertEquals("12039", reservation.getReservationID());
        assertNull(reservation.getUser(), "should be null");
    }
}