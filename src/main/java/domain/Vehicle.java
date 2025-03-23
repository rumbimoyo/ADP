package domain;

/*Vehicle.java
Vehicle model class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

import java.util.Objects;
import java.util.Set;

public class Vehicle {
    private String licensePlate;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleColour;
    private String vehicleVIN;
    private Set<String> tickets;
    private Set<String> reservations;

    private Vehicle(Builder builder) {
        this.licensePlate = builder.licensePlate;
        this.vehicleMake = builder.vehicleMake;
        this.vehicleModel = builder.vehicleModel;
        this.vehicleColour = builder.vehicleColour;
        this.vehicleVIN = builder.vehicleVIN;
        this.tickets = builder.tickets;
        this.reservations = builder.reservations;
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

    public Set<String> getTickets() {
        return tickets;
    }

    public Set<String> getReservations() {
        return reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(licensePlate, vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleColour='" + vehicleColour + '\'' +
                ", vehicleVIN='" + vehicleVIN + '\'' +
                '}';
    }

    public static class Builder {
        private String licensePlate;
        private String vehicleMake;
        private String vehicleModel;
        private String vehicleColour;
        private String vehicleVIN;
        private Set<String> tickets;
        private Set<String> reservations;

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

        public Builder setTickets(Set<String> tickets) {
            this.tickets = tickets;
            return this;
        }

        public Builder setReservations(Set<String> reservations) {
            this.reservations = reservations;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
