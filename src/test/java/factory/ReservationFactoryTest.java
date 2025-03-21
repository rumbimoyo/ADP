//package factory;
//
//public class ReservationFactoryTest {
//}
package factory;

import domain.ParkingSpot;
import domain.Reservation;
import domain.User;
// import domain.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReservationFactoryTest {

    private User testUser;
    // private Vehicle testVehicle;
    private ParkingSpot testParkingSpot;
    private Date testDate;
    private String testStartTime;
    private String testEndTime;
    private double testPrice;

    @BeforeEach
    void setUp() {
        testUser = UserFactory.createUser("John", "Doe", "john@example.com", "password123", "0123456789");
        // testVehicle = VehicleFactory.createVehicle("ABC123", "Toyota", "Corolla", "Red", 2020);
        testParkingSpot = ParkingSpotFactory.createParkingSpot("A1", "Regular", "open", 10.0);
        testDate = new Date();
        testStartTime = "09:00";
        testEndTime = "11:00";
        testPrice = 20.0;
    }

    @Test
    void createReservationComplete() {
        // When
        Reservation reservation = ReservationFactory.createReservation(
                testUser,
                null, // No vehicle for now
                testParkingSpot,
                testDate,
                testStartTime,
                testEndTime,
                testPrice
        );

        // Then
        assertNotNull(reservation);
        assertNotNull(reservation.getReservationID());
        assertEquals(testUser, reservation.getUser());
        // assertEquals(testVehicle, reservation.getVehicle());
        assertEquals(testParkingSpot, reservation.getParkingSpot());
        assertEquals(testDate, reservation.getDate());
        assertEquals(testStartTime, reservation.getStartTime());
        assertEquals(testEndTime, reservation.getEndTime());
        assertEquals(testPrice, reservation.getPrice(), 0.01);
    }

    @Test
    void createReservationMinimal() {
        // When
        Reservation reservation = ReservationFactory.createReservation(
                null,
                null,
                testParkingSpot,
                testDate,
                testStartTime,
                testEndTime,
                testPrice
        );

        // Then
        assertNotNull(reservation);
        assertNotNull(reservation.getReservationID());
        assertNull(reservation.getUser());
        // assertNull(reservation.getVehicle());
        assertEquals(testParkingSpot, reservation.getParkingSpot());
        assertEquals(testDate, reservation.getDate());
        assertEquals(testStartTime, reservation.getStartTime());
        assertEquals(testEndTime, reservation.getEndTime());
        assertEquals(testPrice, reservation.getPrice(), 0.01);
    }

    @Test
    void createReservationWithoutParkingSpot() {
        // When
        Reservation reservation = ReservationFactory.createReservation(
                testUser,
                null,
                null,
                testDate,
                testStartTime,
                testEndTime,
                testPrice
        );

        // Then
        assertNotNull(reservation);
        assertNotNull(reservation.getReservationID());
        assertEquals(testUser, reservation.getUser());
        // assertNull(reservation.getVehicle());
        assertNull(reservation.getParkingSpot());
        assertEquals(testDate, reservation.getDate());
        assertEquals(testStartTime, reservation.getStartTime());
        assertEquals(testEndTime, reservation.getEndTime());
        assertEquals(testPrice, reservation.getPrice(), 0.01);
    }

    @Test
    void createReservationWithoutTime() {
        // When
        Reservation reservation = ReservationFactory.createReservation(
                testUser,
                null,
                testParkingSpot,
                testDate,
                null,
                null,
                testPrice
        );

        // Then
        assertNotNull(reservation);
        assertNotNull(reservation.getReservationID());
        assertEquals(testUser, reservation.getUser());
        // assertNull(reservation.getVehicle());
        assertEquals(testParkingSpot, reservation.getParkingSpot());
        assertEquals(testDate, reservation.getDate());
        assertNull(reservation.getStartTime());
        assertNull(reservation.getEndTime());
        assertEquals(testPrice, reservation.getPrice(), 0.01);
    }

    @Test
    void uniqueIDsGenerated() {
        // When
        Reservation reservation1 = ReservationFactory.createReservation(
                testUser,
                null,
                testParkingSpot,
                testDate,
                testStartTime,
                testEndTime,
                testPrice
        );

        Reservation reservation2 = ReservationFactory.createReservation(
                testUser,
                null,
                testParkingSpot,
                testDate,
                testStartTime,
                testEndTime,
                testPrice
        );

        // Then
        assertNotEquals(reservation1.getReservationID(), reservation2.getReservationID());
    }

    @Test
    void createReservationWithSpecificID() {
        // Given
        String customID = "RES12345";

        // When
        Reservation reservation = ReservationFactory.createReservationWithID(
                customID,
                testUser,
                null,
                testParkingSpot,
                testDate,
                testStartTime,
                testEndTime,
                testPrice
        );

        // Then
        assertNotNull(reservation);
        assertEquals(customID, reservation.getReservationID());
    }
}