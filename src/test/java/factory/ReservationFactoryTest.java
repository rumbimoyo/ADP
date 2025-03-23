//package factory;
//
//public class ReservationFactoryTest {
//}
package factory;

import domain.*;
// import domain.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ReservationFactoryTest {

    private User testUser;
    private Vehicle testVehicle;
    private ParkingSpot testParkingSpot;
    private Date testDate;
    private String testStartTime;
    private String testEndTime;
    private double testPrice;
    private ParkingLot parkingLot;
    private final Set<Reservation> reservations = new HashSet<>();


    @BeforeEach
    void setUp() {
        parkingLot = ParkingLotFactory.createParkingLot("1","Cape Town","08:00am","12:00pm",12.0);
        testUser = UserFactory.createUser("001","TTTT",32,"0877977","hdhd@gmail.com");
        //testVehicle = VehicleFactory.createVehicle("ABC123", "Toyota", "Corolla", "Red", 2020);
        testParkingSpot = ParkingSpotFactory.createParkingSpot(1, "open", "compact", parkingLot);
        testDate = new Date();
        testStartTime = "09:00";
        testEndTime = "11:00";
        testPrice = 20.0;
    }

    @Test
    void createReservationComplete() {
        // When
        Reservation reservation = ReservationFactory.createReservation("01",testStartTime,testEndTime,testDate,testPrice,testParkingSpot,testUser);

        // Then
        System.out.println(reservation);
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
    void createReservationwithTimeAndParkingSpot() {
        // When
        Reservation reservation = ReservationFactory.createBasicReservation("01",testStartTime,testEndTime,testDate,testParkingSpot);

        // Then
        System.out.println(reservation);
        assertNotNull(reservation);
        assertNotNull(reservation.getReservationID());
        assertEquals(testDate, reservation.getDate());
        assertEquals(testStartTime, reservation.getStartTime());
        assertEquals(testEndTime, reservation.getEndTime());
    }

}