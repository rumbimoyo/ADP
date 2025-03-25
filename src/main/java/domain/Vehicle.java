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
    private Set<User> users;

    private Vehicle(Builder builder) {
        this.licensePlate = builder.licensePlate;
        this.vehicleMake = builder.vehicleMake;
        this.vehicleModel = builder.vehicleModel;
        this.vehicleColour = builder.vehicleColour;
        this.vehicleVIN = builder.vehicleVIN;
        this.tickets = builder.tickets;
        this.reservations = builder.reservations;
        this.users = builder.users;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public String getVehicleVIN() {
        return vehicleVIN;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public Set<User> getUsers() {
        return users;
    }

    public static class Builder {
        private String licensePlate;
        private String vehicleMake;
        private String vehicleModel;
        private String vehicleColour;
        private String vehicleVIN;
        private Set<Ticket> tickets;
        private Set<Reservation> reservations;
        private Set<User> users;

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

        public Builder setUsers(Set<User> users) {
            this.users = users;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
