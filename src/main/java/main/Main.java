package main;

import domain.*;
import domain.ParkingLot;
import factory.ParkingLotFactory;
import factory.ParkingSpotFactory;
import factory.UserFactory;
import service.UserService;
import factory.TicketFactory;

import java.time.LocalDate;
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
                111, "open","compact", lot1);
        System.out.println("Parking Spot 1: " + spot1);

    }}






