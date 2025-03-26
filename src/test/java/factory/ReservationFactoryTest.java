package factory;

import domain.ParkingLot;
import domain.ParkingSpot;
import domain.Reservation;
import domain.User;
import domain.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationFactoryTest {

    private User testUser;
    private Vehicle testVehicle;
    private ParkingSpot testParkingSpot;
    private ParkingLot testParkingLot;
    private Date testDate;
    private String testStartTime;
    private String testEndTime;
    private double testPrice;

    @BeforeEach
    public void setUp() {
        // Keep existing setup but update to match actual Builder patterns
        testParkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setLocation("Downtown")
                .build();  // Simplified for testing

        testParkingSpot = new ParkingSpot.Builder()
                .setSpotNumber(101)
                .setStatus("open")
                .setType("compact")
                .setParkingLot(testParkingLot)
                .build();

        testUser = new User.Builder()
                .setUserID("U001")
                .setName("Test User")
                .build();

        testVehicle = new Vehicle.Builder()
                .setLicensePlate("ABC123")
                .build();

        testDate = new Date();
        testStartTime = "09:00";
        testEndTime = "11:00";
        testPrice = 20.0;
    }

    // ===== CORE FUNCTIONALITY TESTS =====
    @Test
    @DisplayName("Valid full reservation creation")
    void validFullReservation() {
        Reservation res = ReservationFactory.createFullReservation(
                "RES-001", testStartTime, testEndTime, testDate,
                testPrice, testVehicle, testParkingSpot, testUser
        );

        assertNotNull(res, "Should create valid reservation");
        assertEquals(testVehicle, res.getVehicle());
        assertEquals(testUser, res.getUser());
    }

    @Test
    @DisplayName("Basic reservation with default price")
    void validBasicReservation() {
        Reservation res = ReservationFactory.createBasicReservation(
                "RES-002", "13:00", "15:00", testDate, testParkingSpot
        );

        assertNotNull(res, "Should create basic reservation");
        assertEquals(0.0, res.getPrice(), "Default price should be 0.0");
        assertNull(res.getVehicle(), "Vehicle should be null");
    }

    // ===== VALIDATION FAILURE TESTS =====
    @Test
    @DisplayName("Full reservation requires vehicle and user")
    void fullReservationRequiresVehicleAndUser() {
        // Test missing vehicle
        Reservation noVehicle = ReservationFactory.createFullReservation(
                "RES-003", testStartTime, testEndTime, testDate,
                testPrice, null, testParkingSpot, testUser
        );
        assertNull(noVehicle, "Should reject null vehicle");

        // Test missing user
        Reservation noUser = ReservationFactory.createFullReservation(
                "RES-004", testStartTime, testEndTime, testDate,
                testPrice, testVehicle, testParkingSpot, null
        );
        assertNull(noUser, "Should reject null user");
    }

    @Test
    @DisplayName("Time format validation")
    void timeFormatValidation() {
        // Invalid time formats
        Reservation invalidStart = ReservationFactory.createBasicReservation(
                "RES-005", "25:00", testEndTime, testDate, testParkingSpot
        );
        assertNull(invalidStart, "Should reject invalid start time");

        // Valid boundary case
        Reservation validLate = ReservationFactory.createBasicReservation(
                "RES-006", "23:59", "24:00", testDate, testParkingSpot
        );
        assertNull(validLate, "Should reject 24:00 end time");
    }

    @Test
    @DisplayName("Price validation")
    void priceValidation() {
        // Negative price
        Reservation negativePrice = ReservationFactory.createFullReservation(
                "RES-007", testStartTime, testEndTime, testDate,
                -10.0, testVehicle, testParkingSpot, testUser
        );
        assertNull(negativePrice, "Should reject negative price");
    }

    // ===== EDGE CASE TESTS =====
    @Test
    @DisplayName("Boundary time validation")
    void boundaryTimeValidation() {
        // Valid late reservation
        Reservation lateRes = ReservationFactory.createBasicReservation(
                "RES-008", "23:59", "23:59", testDate, testParkingSpot
        );
        assertNotNull(lateRes, "Should allow 23:59 times");

        // Invalid time order
        Reservation wrongOrder = ReservationFactory.createBasicReservation(
                "RES-009", "12:00", "11:00", testDate, testParkingSpot
        );
        assertNull(wrongOrder, "Should reject reversed times");
    }

    @Test
    @DisplayName("Walk-in reservation without user")
    void validWalkInReservation() {
        Reservation walkIn = ReservationFactory.createWalkInReservation(
                "RES-010", testStartTime, testEndTime, testDate,
                testPrice, testVehicle, testParkingSpot
        );

        assertNotNull(walkIn, "Should allow vehicle-only reservations");
        assertNull(walkIn.getUser(), "Walk-in should have no user");
    }
}