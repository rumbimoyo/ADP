package main;

import domain.*;
import factory.*;
import repository.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Initialize repositories for different entities
        UserRepository urepo = UserRepository.getInstance();
        ParkingLotRepository plrepo = ParkingLotRepository.getInstance();
        ReservationRepository rrepo = ReservationRepository.getInstance();
        VehicleRepository vrepo = VehicleRepository.getInstance();
        TicketRepository trepo = TicketRepository.getInstance();
        ParkingSpotRepository prepo = ParkingSpotRepository.getInstance();

        // Performing CRUD operations on User repository
        User user = UserFactory.createUser("2673", "John", LocalDate.of(2004, 9, 9), "male", "081-234-0192", "john@gmail.com");
        User user1 = UserFactory.createUser("2673","patric", LocalDate.of(2005,2,1), "female","patrick@gmail.com");
        User user2 = UserFactory.createUser("2001","james", "james@gmail.com", LocalDate.of(1999,1,2), "081-201-2990");

        // Retrieve all users and print them
        urepo.create(user);
        urepo.read(user.getUserID());
        urepo.update(user1);

        urepo.create(user2);
        urepo.delete(user2.getUserID());

        Set<User> users = urepo.getAll();


        // Retrieve all users and print them
        System.out.println("--User--");
        for(User u: users){
            System.out.println(u.toString());
        }

        // Creating ParkingLots
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL001", "City Center Parking", "Downtown", "08:00 AM", "20:00 PM", 5.0);
        ParkingLot parkingLot1 = ParkingLotFactory.createParkingLot("PL002", "Mall Parking", "Uptown", "09:00 AM", 4.0);
        ParkingLot parkingLot2 = ParkingLotFactory.createParkingLot("PL003", "Garage Parking", "Midtown", 3.5);


        // Performing CRUD operations on ParkingLot repository
        plrepo.create(parkingLot);
        plrepo.read(parkingLot.getLotId());
        plrepo.update(parkingLot1);

        plrepo.create(parkingLot2);
        plrepo.delete(parkingLot2.getLotId());


        // Retrieve all parking lots and print them
        Set<ParkingLot> parkingLots = plrepo.getAll();



        System.out.println("--Parking Lots--");
        for(ParkingLot l: parkingLots){
            System.out.println(l.toString());
        }

        // Creating Reservation dependencies (Vehicle, User, ParkingSpot)
        Vehicle testVehicle = VehicleFactory.createVehicle("001211", "Honda", "Civic", "black", "1F87A123456789000");

        User testUser = UserFactory.createUser("811", "Sean Bailey", LocalDate.of(2001, 9,9), "male", "081-222-1111", "sean@gmail.com");
        ParkingLot testParkingLot = ParkingLotFactory.createParkingLot("201", "OpenSeason", "12 Avenue CPUT", 12.25);
        ParkingSpot testParkingSpot = ParkingSpotFactory.createParkingSpot(111, "open", "compact", testParkingLot);


        // Creating Reservations
        Reservation reservation = ReservationFactory.createReservation("12345", "09:00 AM", "10:00 AM", LocalDate.of(2025, 04,01), 10.50, testVehicle, testParkingSpot, testUser);
        Reservation reservation1 = ReservationFactory.createReservation("81922", "09:00 AM", "10:00 PM", LocalDate.of(2025, 04,01), 10.50, testParkingSpot, testUser);
        Reservation reservation2 = ReservationFactory.createReservation("12039", "09:00 PM", "10:00 AM", LocalDate.of(2025, 04,01), 10.50, testVehicle, testParkingSpot);

        // Performing CRUD operations on Reservation repository
        rrepo.create(reservation);
        rrepo.read(reservation1.getReservationID());
        rrepo.update(reservation1);

        rrepo.create(reservation2);
        rrepo.delete(reservation2.getReservationID());


        // Retrieve all reservations and print them
        Set<Reservation> reservations = rrepo.getAll();


        System.out.println("--Reservation--");
        for(Reservation r: reservations){
            System.out.println(r.toString());
        }


        // Creating Vehicles with different constructors
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "Red", "VIN123456", users);
        Vehicle vehicle1 = VehicleFactory.createVehicle("CA123456", "Corolla", "Red", users, "VIN123456");
        Vehicle vehicle2 = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "VIN123456", users);


        // Performing CRUD operations on Vehicle repository
        vrepo.create(vehicle);
        vrepo.read(vehicle1.getLicensePlate());
        vrepo.update(vehicle1);

        vrepo.create(vehicle2);
        vrepo.delete(vehicle2.getLicensePlate());

        // Retrieve all reservations and print them
        Set<Vehicle> vehicles = vrepo.getAll();


        System.out.println("--Vehicle--");
        for(Vehicle v: vehicles){
            System.out.println(v.toString());
        }


        // Creating Tickets
        Ticket ticket = TicketFactory.createTicket("12345", "10:10 AM", "11:31 AM",50.00, LocalDate.of(2025,02,02), parkingLot, vehicle);
        Ticket ticket1 = TicketFactory.createTicket("12345", "11:01 AM", "10:31 PM",25.00, LocalDate.of(2025,03,02), parkingLot, vehicle);
        Ticket ticket2 = TicketFactory.createTicket("12345", "10:10 AM", "11:31 AM",50.00, parkingLot, vehicle);

        // Performing CRUD operations on Ticket repository
        trepo.create(ticket);
        trepo.read(ticket.getTicketID());
        trepo.update(ticket1);

        trepo.create(ticket2);
        trepo.delete(ticket2.getTicketID());


        // Retrieve all tictets and print them
        Set<Ticket> tickets = trepo.getAll();


        System.out.println("--Ticket--");
        for(Ticket t : tickets){
            System.out.println(t.toString());
        }

        // Creating Parking Spots
        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(
                111, "occupied","disabled" ,parkingLot);
        ParkingSpot parkingSpot1 = ParkingSpotFactory.createParkingSpot(
                112, "open","compact");
        ParkingSpot parkingSpot2 = ParkingSpotFactory.createParkingSpot(
                101, "open");

        // Performing CRUD operations on ParkingSpot repository
        prepo.create(parkingSpot);
        prepo.read(parkingSpot1.getSpotNumber());
        prepo.update(parkingSpot1);

        prepo.update(parkingSpot2);
        prepo.delete(parkingSpot2.getSpotNumber());

        // Retrieve all parking spots and print them
        Set<ParkingSpot> parkingSpots = prepo.getAll();

        System.out.println("--ParkingSpots--");
        for(ParkingSpot s: parkingSpots){
            System.out.println(s.toString());
        }

    }}






