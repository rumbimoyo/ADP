package service;

/*
service.UserService
User Service class
Author: Sean Joel Bailey (230645682)
Date: 18/03/2025
 */

import domain.*;
import repository.*;

import java.util.HashSet;
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

    // finds users associated with vehicle
//    public Set<User> findVehicleUsers(Vehicle vehicle){return vehicle.getUsers();};

    // editing user profile
    public User editUser(User user){
        return urepo.update(user);
    }

    public void deleteProfile(String userID){urepo.delete(userID);};

    public void addReservation(Reservation reservation){

//        User user;
//        Vehicle vehicle;
//
//        // reservation for vehicle and user
//        if(reservation.getUser() != null && reservation.getVehicle !=null){
//
//            String userID = reservation.getUser().getID();
//            user = urepo.read(userID);
//            user.getReservations().add(reservation);
//
//            String licencePlate = reservation.getVehicle().getLicencePlate();
//            vehicle = vrepo.read(licencePlate);
//            vehicle.getReservations().add(reservation);
//
//            urepo.update(user);
//            vrepo.update(vehicle);
//            rrepo.update(reservation);
//
//        }
//
//        // reservation for user
//        else if (reservation.getUser() != null) {
//
//            String userID = reservation.getUser().getID();
//            user = urepo.read(userID);
//            user.getReservations().add(reservation);
//
//            urepo.update(user);
//            rrepo.update(reservation);
//
//        }
//
//        // reservation for vehicle
//        else if(reservation.getVehicle() != null){
//
//            String licencePlate = reservation.getVehicle().getLicencePlate();
//            vehicle = vrepo.read(licencePlate);
//            vehicle.getReservations().add(reservation);
//
//            vrepo.update(vehicle);
//            rrepo.update(reservation);
//
//        }

    }

    // view user specific reservation
    public Set<Reservation> viewUserReservations(User user){
        return user.getReservations();
    }

     // view vehicle specific reservation
//    public Set<Reservation> viewVehicleReservations(Vehicle vehicle){return vehicle.getReservations();}

    // view reservation for both vehicle and user
//    public Set<Reservation> viewAllReservations(User user){return user.getReservations() + user.getVehicles().getReservations();}

    public void editReservation(Reservation reservation){

//        User user;
//        Vehicle vehicle;
//        Reservation oldReservation = rrepo.read(reservation.getReservationID());
//
//        // reservation for vehicle and user
//        if(reservation.getUser() != null && reservation.getVehicle !=null){
//
//            String userID = reservation.getUser().getID();
//            user = urepo.read(userID);
//            user.getReservations().remove(oldReservation);
//            user.getReservations().add(reservation);
//
//            String licencePlate = reservation.getVehicle().getLicencePlate();
//            vehicle = vrepo.read(licencePlate);
//            vehicle.getReservations().remove(oldReservation);
//            vehicle.getReservations().add(reservation);
//
//            urepo.update(user);
//            vrepo.update(vehicle);
//            rrepo.update(reservation);
//
//        }
//
//        // reservation for user
//        else if (reservation.getUser() != null) {
//
//            String userID = reservation.getUser().getID();
//            user = urepo.read(userID);
//            user.getReservations().remove(oldReservation);
//            user.getReservations().add(reservation);
//
//            urepo.update(user);
//            rrepo.update(reservation);
//        }
//
//        // reservation for vehicle
//        else if(reservation.getVehicle() != null){
//
//            String licencePlate = reservation.getVehicle().getLicencePlate();
//            vehicle = vrepo.read(licencePlate);
//            vehicle.getReservations().add(reservation);
//
//            vrepo.update(vehicle);
//            rrepo.update(reservation);
//
//        }

    }

    public Set<Vehicle> viewVehicles(User user){
        return user.getVehicles();
    }

    public void editVehicle(Vehicle newVehicle){
//        // updates vehicle in repository
//        vrepo.update(newVehicle);
//
//        // to replace the old user vehicle with new vehicle
//        Vehicle oldVehicle = vrepo.read(newVehicle.getLicencePlate()); // finds old vehicle
//        Set<User> vehicleUsers = oldVehicle.getUsers(); // gets users that have old vehicle registered
//        for(User user: vehicleUsers){
//            Set<Vehicle> vec = user.getVehicles();
//            vec.remove(oldVehicle);
//            vec.add(newVehicle);
//            urepo.update(user);
//        }

    }

//    public Set<Ticket> viewTickets(User user){
//        return user.getVehicles().getTickets();
//    }

//    public Set<ParkingSpot> viewParkingSpots(ParkingLot parkingLot){
//        return parkingLot.getParkingSpots();
//    }



}
