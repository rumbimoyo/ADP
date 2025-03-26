package main;

import domain.*;
import factory.*;
import service.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Initialize services
        UserService userService = new UserService();
        ReservationService reservationService = ReservationService.getInstance();

        // Create a User
        User user = UserFactory.createUser("2673", "John", LocalDate.of(2004, 9, 9),
                "male", "081-234-0192", "john@gmail.com");
        userService.addUser(user);

        // Create ParkingLot objects
        ParkingLot lot1 = ParkingLotFactory.createParkingLot("PL001", "Downtown Lot", "City Center",
                "06:00 AM", "10:00 PM", 5.50);
        ParkingLot lot2 = ParkingLotFactory.createParkingLot("PL002", "Airport Parking", "International Terminal",
                "24/7", "24/7", 10.00);

        // Print parking lot details
        System.out.println("Parking Lot 1: " + lot1);
        System.out.println("Parking Lot 2: " + lot2);

        // Create a ParkingSpot object
        ParkingSpot spot1 = ParkingSpotFactory.createParkingSpot(101, "open", "compact", lot1);
        System.out.println("Parking Spot 1: " + spot1);

        // Occupy the parking spot
        if (spot1 != null) {
            spot1.setStatus("occupied");
            System.out.println("After occupying Parking Spot 1: " + spot1);
        } else {
            System.out.println("Failed to create Parking Spot.");
        }
    }

}
//        // Create a Vehicle using the Builder pattern
//        Vehicle vehicle = new Vehicle.Builder("ABC123")
//                .make("Toyota")
//                .model("Corolla")
//                .year(2020)
//                .color("Blue")
//                .build();
//
//        // Create Reservation objects using the ReservationFactory
//        Reservation res1 = ReservationFactory.createReservation("R001", "08:00", "10:00", new Date(),
//                100.0, vehicle, spot1, user);
//        Reservation res2 = ReservationFactory.createReservation("R002", "10:30", "12:30", new Date(),
//                120.0, vehicle, spot1, user);
//        Reservation res3 = ReservationFactory.createReservation("R003", "13:00", "15:00", new Date(),
//                150.0, vehicle, spot1, user);
//
//        // Add reservations
//        reservationService.addReservation(res1);
//        reservationService.addReservation(res2);
//        reservationService.addReservation(res3);
//
//        // Delete one reservation
//        reservationService.deleteReservation("R001");
//
//        // View and print all remaining reservations
//        Set<Reservation> remainingReservations = reservationService.viewUserReservations(user);
//        System.out.println("Remaining Reservations:");
//        for (Reservation res : remainingReservations) {
//            System.out.println(res);
//        }
//
//        if (remainingReservations.size() >= 2) {
//            System.out.println("Success: At least 2 reservations remain in the repository.");
//        } else {
//            System.out.println("Error: Less than 2 reservations remain in the repository.");
//        }
//    }
//}
