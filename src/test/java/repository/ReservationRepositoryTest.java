package repository;

import domain.*;
import factory.ParkingLotFactory;
import factory.ParkingSpotFactory;
import factory.UserFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ReservationRepositoryTest {

    private ParkingLot parkingLot = ParkingLotFactory.createParkingLot("1","Cape Town","08:00am","12:00pm",12.0);
//    private User testUser = UserFactory.createUser("001","TTTT",32,"0877977","hdhd@gmail.com");
    //private Vehicle testVehicle = VehicleFactory.createVehicle("ABC123", "Toyota", "Corolla", "Red", 2020);
    private ParkingSpot testParkingSpot = ParkingSpotFactory.createParkingSpot(1, "open", "compact", parkingLot);

    ReservationRepository reservationRepository = ReservationRepository.getInstance();

    @Test
    public void a_CreateReservation() {
        Reservation reservation = new Reservation.Builder()
                .setReservationID("PL001")
                .setDate(new Date())
                .setStartTime("08:00")
                .setEndTime("20:00")
                .setPrice(5.0)
                .setUser(testUser)
                //.setVehicle(testVehicle)
                .setParkingSpot(testParkingSpot)
                .build();

        reservationRepository.create(reservation);

        assertNotNull(reservation);
    }

    @Test
    public void b_ReadReservation() {
        Reservation reservation = reservationRepository.read("PL001");

        assertNotNull(reservation);
        assertEquals("PL001", reservation.getReservationID());
    }

    @Test
    public void c_UpdateReservation() {
        Reservation reservation = new Reservation.Builder()
                .setReservationID("PL001")
                .setDate(new Date())
                .setStartTime("08:00")
                .setEndTime("20:00")
                .setPrice(100)
                .setUser(testUser)
                //.setVehicle(testVehicle)
                .setParkingSpot(testParkingSpot)
                .build();

        Reservation updatedReservation = reservationRepository.update(reservation);
        assertNotNull(reservation);
        assertEquals("PL001", updatedReservation.getReservationID());
        assertEquals(100, reservation.getPrice());

    }

    @Test
    public void d_GetAllReservations() {
        HashSet hashSet = new HashSet<>();

        hashSet.add(reservationRepository.getAll());

        assertNotNull(hashSet);
    }

    @Test
    public void e_DeleteReservation() {
        String reservationId = "PL001";
        Boolean deleted = reservationRepository.delete(reservationId);

        HashSet hashSet = new HashSet<>();
        hashSet.add(reservationRepository.getAll());

        //assertNull(hashSet);
        System.out.println(hashSet);
        assertTrue(deleted);

    }
}