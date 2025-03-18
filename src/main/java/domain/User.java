package domain;

/*
domain.User
User entity class
Author: Sean Joel Bailey (230645682)
Date: 17/03/2025
 */

import java.util.Set;

public class User {

    private String userID, name, contactNumber, email;
    private int age;
    private Set<Vehicle> vehicles;
    private Set<Reservation> reservations;

    public User(){

    }

    public User(String userID, String name, int age,
                String contactNumber, String email,
                Set<Vehicle> vehicles, Set<Reservation> reservations) {
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

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", vehicles=" + vehicles +
                ", reservations=" + reservations +
                '}';
    }

    public static class Builder{
        private String userID, name, contactNumber, email;
        private int age;
        private Set<Vehicle> vehicles;
        private Set<Reservation> reservations;

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
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

        public Builder setVehicles(Set<Vehicle> vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        public Builder setReservations(Set<Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        public User build(){return new User(userID, name, age, contactNumber, email, vehicles, reservations);}
    }
}
