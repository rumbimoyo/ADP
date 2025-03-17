package factory;

/*
Factory.UserFactory
User Factory class
Author: Sean Joel Bailey (230645682)
Date: 17/03/2025
 */

import domain.User;
import domain.Vehicle;
import domain.Reservation;

import java.util.HashSet;

public class UserFactory {

    // creates user object with all attributes
    public static User createUser(String userID, String name, String age,
                                  String contactNumber, String email,
                                  HashSet<Vehicle> vehicles, HashSet<Reservation> reservations){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .setVehicles(vehicles)
                .setReservations(reservations)
                .build();

    }

    // creates a user without reservations
    public static User createUser(String userID, String name, String age,
                                  String contactNumber, HashSet<Vehicle> vehicles, String email){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .setVehicles(vehicles)
                .build();

    }

    // creates user object without vehicles
    public static User createUser(String userID, String name, String age,
                                  String contactNumber, String email,
                                  HashSet<Reservation> reservations){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .setReservations(reservations)
                .build();

    }

    // creates user object without contactNumber
    public static User createUser(String userID, String name, String age,
                                  String email,
                                  HashSet<Vehicle> vehicles, HashSet<Reservation> reservations){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setEmail(email)
                .setVehicles(vehicles)
                .setReservations(reservations)
                .build();

    }



}
