package service;

/*
service.UserService
User Service class
Author: Sean Joel Bailey (230645682)
Date: 18/03/2025
 */

import domain.*;
import repository.*;

import java.util.Set;

public class UserService {

    // for implementation of singleton
    private final UserRepository urepo = UserRepository.getInstance();
//    private final VehicleRepository vrepo = VehicleRepository.getInstance();
//    private final ReservationRepository rrepo = ReservationRepository.getInstance();

    // adds user to repository
    public void addUser(User user){
        urepo.create(user);
    }

    // finding other user based on id
    public User findUser(String userID){
        return urepo.read(userID);
    }

    // editing user profile
    public User editUser(User user){
        return urepo.update(user);
    }

    // reservation for user
    public void makeReservationUser(User user, Reservation reservation){
        user.getReservations().add(reservation); // add reservation to reservation hashset
        urepo.update(user); // updates user object
//        rrepo.add(reservation);
    }

    // reservation for Vehicle
//    public void makeReservationVehicle(User user, Reservation reservation){
//        Set<Vehicle> vehicles = user.getVehicles();
//        vehicles.getReservations().add(reservation); // add reservation to reservation hashset
//        urepo.update(user); // updates user object
//        rrepo.add(reservation);
//    }

    // reservation for vehicle and user
    public void makeReservationBoth(User user, Reservation reservation){
        user.getReservations().add(reservation); // add reservation to reservation hashset
//        vehicle.getReservations().add(reservation);
        urepo.update(user); // updates user object
//        vrepo.update(vehicle);
//        rrepo.add(reservation);
    }


    // reservations for user
    public Set<Reservation> viewReservationsUser(User user){
        return user.getReservations();
    }

    // reservations for vehicle
//    public Set<Reservation> viewReservationsVehicle(User user){
//        return user.getVehicles().getReservations();
//    }

    // reservations for Both user and vehicle
//    public Set<Reservation> viewReservationsBoth(User user){
//        return user.getReservations() + user.getVehicles().getReservations();
//    }

//    public void editReservation(User user, Reservation newReservation){
//        Set<Reservation> reservations = user.getReservations();
//        for(Reservation oldReservation: reservations) {
//            if (oldReservation.getReservationID().equals(newReservation.getReservationID())) {
//                reservations.remove(oldReservation);
//                reservations.add(newReservation);
//                rrepo.update(newReservation);
//            }
//        }
//    }

    // to add vehicles to user profile
    public void addVehicles(User user, Vehicle vehicle){
        user.getVehicles().add(vehicle);
    }

    public Set<Vehicle> viewVehicles(User user){
        return user.getVehicles();
    }

//    public void editVehicles(User user, Vehicle newVehicle){
//        Set<Vehicle> vehicles = user.getVehicles();
//        for(Vehicle oldVehicles: vehicles) {
//            if (oldVehicles.getReservationID().equals(newVehicle.getReservationID())) {
//                reservations.remove(oldVehicles);
//                reservations.add(newVehicle);
//                vrepo.update(newVehicle);
//            }
//        }
//    }

//    public Set<Ticket> viewTickets(User user){
//        return user.getVehicles().getTickets();
//    }

//    public Set<ParkingSpot> viewParkingSpots(ParkingLot parkingLot){
//        return parkingLot.getParkingSpots();
//    }



}
