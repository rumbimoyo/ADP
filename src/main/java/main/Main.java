package main;

import domain.*;
import factory.*;
import repository.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        UserRepository urepo = UserRepository.getInstance();
        ParkingLotRepository plrepo = ParkingLotRepository.getInstance();
        ReservationRepository rrepo = ReservationRepository.getInstance();
        VehicleRepository vrepo = VehicleRepository.getInstance();
        TicketRepository trepo = TicketRepository.getInstance();
        ParkingSpotRepository prepo = ParkingSpotRepository.getInstance();

        // User
        User user = UserFactory.createUser("2673", "John", LocalDate.of(2004, 9, 9), "male", "081-234-0192", "john@gmail.com");
        User user1 = UserFactory.createUser("2673","patric", LocalDate.of(2005,2,1), "female","patrick@gmail.com");
        User user2 = UserFactory.createUser("2001","james", "james@gmail.com", LocalDate.of(1999,1,2), "081-201-2990");

        urepo.create(user);
        urepo.read(user.getUserID());
        urepo.update(user1);

        urepo.create(user2);
        urepo.delete(user2.getUserID());

        Set<User> users = urepo.getAll();

        // ParkingLot
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL001", "City Center Parking", "Downtown", "08:00", "20:00", 5.0);
        ParkingLot parkingLot1 = ParkingLotFactory.createParkingLot("PL002", "Mall Parking", "Uptown", "09:00", 4.0);
        ParkingLot parkingLot2 = ParkingLotFactory.createParkingLot("PL003", "Garage Parking", "Midtown", 3.5);

        plrepo.create(parkingLot);
        plrepo.read(parkingLot.getLotId());
        plrepo.update(parkingLot1);

        plrepo.create(parkingLot2);
        plrepo.delete(parkingLot2.getLotId());


        Set<ParkingLot> parkingLots = plrepo.getAll();

        //Reservation
        Vehicle testVehicle = VehicleFactory.createVehicle("001211", "Honda", "Civic", "black", "1F87A123456789000");

        User testUser = UserFactory.createUser("811", "Sean Bailey", LocalDate.of(2001, 9,9), "male", "081-222-1111", "sean@gmail.com");
        ParkingLot testParkingLot = ParkingLotFactory.createParkingLot("201", "OpenSeason", "12 Avenue CPUT", 12.25);
        ParkingSpot testParkingSpot = ParkingSpotFactory.createParkingSpot(111, "open", "compact", testParkingLot);

        Reservation reservation = ReservationFactory.createReservation("12345", "09:00 AM", "10:00 AM", LocalDate.of(2025, 04,01), 10.50, testVehicle, testParkingSpot, testUser);
        Reservation reservation1 = ReservationFactory.createReservation("81922", "09:00 AM", "10:00 PM", LocalDate.of(2025, 04,01), 10.50, testParkingSpot, testUser);
        Reservation reservation2 = ReservationFactory.createReservation("12039", "09:00 PM", "10:00 AM", LocalDate.of(2025, 04,01), 10.50, testVehicle, testParkingSpot);







        rrepo.create(reservation);
        rrepo.read(reservation1.getReservationID());
        rrepo.update(reservation1);

        rrepo.create(reservation2);
        rrepo.delete(reservation2.getReservationID());

        Set<Reservation> reservations = rrepo.getAll();

        //Vehicle
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "Red", "VIN123456", users);
        Vehicle vehicle1 = VehicleFactory.createVehicle("CA123456", "Corolla", "Red", users, "VIN123456");
        Vehicle vehicle2 = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "VIN123456", users);

        vrepo.create(vehicle);
        vrepo.read(vehicle1.getLicensePlate());
        vrepo.update(vehicle1);

        vrepo.create(vehicle2);
        vrepo.delete(vehicle2.getLicensePlate());

        Set<Vehicle> vehicles = vrepo.getAll();

        //Ticket
        Ticket ticket = TicketFactory.createTicket("12345", "10:10 AM", "11:31 AM",50.00, LocalDate.of(2025,02,02), parkingLot, vehicle);
        Ticket ticket1 = TicketFactory.createTicket("12345", "10:10 AM", "11:31 AM",50.00, LocalDate.of(2025,02,02), parkingLot);
        Ticket ticket2 = TicketFactory.createTicket("12345", "10:10 AM", "11:31 AM",50.00, parkingLot, vehicle);


        trepo.create(ticket);
        trepo.read(ticket.getTicketID());
        trepo.update(ticket1);

        trepo.update(ticket2);
        trepo.delete(ticket2.getTicketID());

        Set<Ticket> tickets = trepo.getAll();

        //ParkingSpot
        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(
                111, "1","compact" ,parkingLot);
        ParkingSpot parkingSpot1 = ParkingSpotFactory.createParkingSpot(
                111, "open","compact" ,null);
        ParkingSpot parkingSpot2 = ParkingSpotFactory.createParkingSpot(
                101, "open");



        prepo.create(parkingSpot);
        prepo.read(parkingSpot1.getSpotNumber());
        prepo.update(parkingSpot1);


        prepo.update(parkingSpot2);
        prepo.delete(parkingSpot2.getSpotNumber());

        Set<ParkingSpot> parkingSpots = prepo.getAll();
















    }}






