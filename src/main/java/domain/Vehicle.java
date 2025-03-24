package domain;

/*Vehicle.java
Vehicle model class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

import java.util.Set;

public class Vehicle {
    private String licensePlate;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleColour;
    private String vehicleVIN;
    private Set<Ticket> tickets;
    private Set<Reservation> reservations;
    private Set<User> users;  // Added users field


    private Vehicle(Builder builder) {
        this.licensePlate = builder.licensePlate;
        this.vehicleMake = builder.vehicleMake;
        this.vehicleModel = builder.vehicleModel;
        this.vehicleColour = builder.vehicleColour;
        this.vehicleVIN = builder.vehicleVIN;
        this.tickets = builder.tickets;
        this.reservations = builder.reservations;
        this.users = builder.users; // Assign users from Builder
    }


    public static class Builder {
        private String licensePlate;
        private String vehicleMake;
        private String vehicleModel;
        private String vehicleColour;
        private String vehicleVIN;
        private Set<Ticket> tickets;
        private Set<Reservation> reservations;
        private Set<User> users;  // Added users field in Builder

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder setVehicleMake(String vehicleMake) {
            this.vehicleMake = vehicleMake;
            return this;
        }

        public Builder setVehicleModel(String vehicleModel) {
            this.vehicleModel = vehicleModel;
            return this;
        }

        public Builder setVehicleColour(String vehicleColour) {
            this.vehicleColour = vehicleColour;
            return this;
        }

        public Builder setVehicleVIN(String vehicleVIN) {
            this.vehicleVIN = vehicleVIN;
            return this;
        }

        public Builder setTickets(Set<Ticket> tickets) {
            this.tickets = tickets;
            return this;
        }

        public Builder setReservations(Set<Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        public Builder setUsers(Set<User> users) {  // Setter for Users
            this.users = users;
            return this;
        }


        public Vehicle build() {
            return new Vehicle(this);
        }
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleColour='" + vehicleColour + '\'' +
                ", vehicleVIN='" + vehicleVIN + '\'' +
                ", tickets=" + tickets +
                ", reservations=" + reservations +
                ", users=" + users +
                '}';
    }
}
