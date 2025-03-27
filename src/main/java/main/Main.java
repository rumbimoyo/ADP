package main;

import domain.*;
import domain.ParkingLot;
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


        Set<ParkingLot> parkinglot = plrepo.getAll();

        //Reservation
        Reservation reservation = ReservationFactory.createReservation("12345", "09:00 AM", "10:00 AM", LocalDate.of(2025, 04,01), 10.50, testVehicle, testParkingSpot, testUser);
        Reservation reservation1 = ReservationFactory.createReservation("81922", "09:00 AM", "10:00 PM", LocalDate.of(2025, 04,01), 10.50, testParkingSpot, testUser);
        Reservation reservation2 = ReservationFactory.createReservation("12039", "09:00 PM", "10:00 AM", LocalDate.of(2025, 04,01), 10.50, testVehicle, testParkingSpot);


        rrepo.create(reservation);
        rrepo.read(reservation1.getReservationID());
        rrepo.update(reservation1);

        rrepo.create





        Set<User> users = new HashSet<>();




    }}






