package main;

import domain.*;
import domain.ParkingLot;
import factory.ParkingLotFactory;
import factory.ParkingSpotFactory;
import factory.ReservationFactory;
import factory.UserFactory;
import service.UserService;
import service.ReservationService;
import factory.TicketFactory;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        UserService userService = new UserService();
        User user = UserFactory.createUser("2673", "John", LocalDate.of(2004, 9, 9), "male", "081-234-0192", "john@gmail.com");

        userService.addUser(user);
        // Ticket ticket = TicketFactory.createTicket(1, parkingLot, vehicle);

        // Creating ParkingLot objects
        ParkingLot lot1 = ParkingLotFactory.createParkingLot(
                "PL001", "Downtown Lot", "City Center", "06:00 AM", "10:00 PM", 5.50);

        ParkingLot lot2 = ParkingLotFactory.createParkingLot(
                "PL002", "Airport Parking", "International Terminal", "24/7", "24/7", 10.00);

        // Printing the parking lot details
        System.out.println("Parking Lot 1: " + lot1);
        System.out.println("Parking Lot 2: " + lot2);

        // Create a ParkingSpot object using ParkingSpotFactory
        ParkingSpot spot1 = ParkingSpotFactory.createParkingSpot(
                101, "open", "compact", lot1);
        System.out.println("Parking Spot 1: " + spot1);

        // Occupying the parking spot
        if (spot1 != null) {
            spot1.setStatus("occupied"); // Status will change to occupied
            System.out.println("After occupying Parking Spot 1: " + spot1);
        } else {
            System.out.println("Failed to create Parking Spot.");
        }

        // --- Reservation Operations as per group leader requirements ---
        // Create a dummy Vehicle; assuming a constructor exists that accepts a licence plate
      //  Vehicle vehicle = new Vehicle("ABC123");

        // Get the ReservationService instance (using singleton)
        ReservationService reservationService = ReservationService.getInstance();

        // Create three Reservation objects using the ReservationFactory with dummy values
        //Reservation res1 = ReservationFactory.createReservation("R001", "08:00", "10:00", new Date(), 100.0, vehicle, null, user);
        //Reservation res2 = ReservationFactory.createReservation("R002", "10:30", "12:30", new Date(), 120.0, vehicle, null, user);
        //Reservation res3 = ReservationFactory.createReservation("R003", "13:00", "15:00", new Date(), 150.0, vehicle, null, user);

        // Add reservations
//        reservationService.addReservation(res1);
//        reservationService.addReservation(res2);
//        reservationService.addReservation(res3);

        // Delete one reservation to ensure at least two remain
        reservationService.deleteReservation("R001");

        // View and print all remaining reservations
        Set<Reservation> remainingReservations = reservationService.viewReservations();
        System.out.println("Remaining Reservations:");
        for (Reservation res : remainingReservations) {
            System.out.println(res);
        }

        if (remainingReservations.size() >= 2) {
            System.out.println("Success: At least 2 reservations remain in the repository.");
        } else {
            System.out.println("Error: Less than 2 reservations remain in the repository.");
        }
    }
}
