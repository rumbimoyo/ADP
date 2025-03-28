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
    private Set<User> users;

    public Vehicle(){

    }

    public Vehicle(String licensePlate, String vehicleMake, String vehicleModel, String vehicleColour, String vehicleVIN, Set<User> users) {
        this.licensePlate = licensePlate;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleColour = vehicleColour;
        this.vehicleVIN = vehicleVIN;
        this.users = users;
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

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleColour='" + vehicleColour + '\'' +
                ", vehicleVIN='" + vehicleVIN + '\'' +
                ", users=" + users +
                '}';
    }

    public static class Builder {
        private String licensePlate;
        private String vehicleMake;
        private String vehicleModel;
        private String vehicleColour;
        private String vehicleVIN;
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


        public Builder setUsers(Set<User> users) {
            this.users = users;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(licensePlate, vehicleMake, vehicleModel, vehicleColour, vehicleVIN, users);
        }
    }
}
