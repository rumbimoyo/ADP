package factory;

/*
factory.userFactory
User Factory class
Author: Sean Joel Bailey (230645682)
Date: 17/03/2025
 */

import domain.User;
import domain.Vehicle;
import domain.Reservation;

import java.util.Set;

public class UserFactory {

    // creates user object with all attributes
    public static User createUser(String userID, String name, int age,
                                  String contactNumber, String email,
                                  Set<Vehicle> vehicles, Set<Reservation> reservations){

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
    public static User createUser(String userID, String name, int age,
                                  String contactNumber, Set<Vehicle> vehicles, String email){

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
    public static User createUser(String userID, String name, int age,
                                  String contactNumber, String email,
                                  Set<Reservation> reservations){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .setReservations(reservations)
                .build();

    }

    // creates user without vehicle or reservation
    public static User createUser(String userID, String name, int age,
                                  String contactNumber, String email){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .build();

    }

    // creates user object without contactNumber
    public static User createUser(String userID, String name, int age, String email,
                                  Set<Vehicle> vehicles, Set<Reservation> reservations){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setEmail(email)
                .setVehicles(vehicles)
                .setReservations(reservations)
                .build();

    }

    // create user with no contact number or vehicle
    public static User createUser(String userID, String name, int age,
                                  String email, Set<Reservation> reservations){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setEmail(email)
                .setReservations(reservations)
                .build();

    }

    // no contact number and reservation
    public static User createUser(String userID, String name, int age,
                                  Set<Vehicle> vehicles,  String email){

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setAge(age)
                .setEmail(email)
                .setVehicles(vehicles)
                .build();

    }

}
