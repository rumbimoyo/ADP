package domain;

/*
domain.User.
User entity class
Author: Sean Joel Bailey (230645682)
Date: 17/03/2025
 */

import java.util.HashSet;

public class User {

    private String userID, name, age, contactNumber, email;
    private HashSet<Vehicle> vehicles;
    private HashSet<Reservation> reservations;

    public User(){

    }

    public User(String userID, String name, String age,
                String contactNumber, String email,
                HashSet<Vehicle> vehicles, HashSet<Reservation> reservations) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.email = email;
        this.vehicles = vehicles;
        this.reservations = reservations;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public HashSet<Vehicle> getVehicles() {
        return vehicles;
    }

    public HashSet<Reservation> getReservations() {
        return reservations;
    }

    public static class Builder{
        private String userID, name, age, contactNumber, email;
        private HashSet<Vehicle> vehicles;
        private HashSet<Reservation> reservations;

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setVehicles(HashSet<Vehicle> vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        public Builder setReservations(HashSet<Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        public User build(){return new User(userID, name, age, contactNumber, email, vehicles, reservations);}
    }
}
