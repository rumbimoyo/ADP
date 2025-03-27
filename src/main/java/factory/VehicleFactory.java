package factory;
import domain.User;
import domain.Vehicle;
import util.Helper;

import java.util.Set;

/* VehicleFactory.java
   Vehicle Factory class
   Author: Casey Abigail Nolte (218275161)
   Date: 21 March 2025
*/

public class VehicleFactory {

    // vehicle with all attributes
    public static Vehicle createVehicle(String licensePlate, String vehicleMake, String vehicleModel, String vehicleColour, String vehicleVIN, Set<User> users) {
        if (Helper.isNullorEmpty(licensePlate) ||
                Helper.isNullorEmpty(vehicleMake) ||
                Helper.isNullorEmpty(vehicleModel) ||
                Helper.isNullorEmpty(vehicleColour) ||
                Helper.isNullorEmpty(vehicleVIN) ||
                Helper.isNullorEmpty(users)) {
            return null;
        }

        // Create the Vehicle without reservations
        return new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleMake(vehicleMake)
                .setVehicleModel(vehicleModel)
                .setVehicleColour(vehicleColour)
                .setVehicleVIN(vehicleVIN)
                .setUsers(users)
                .build();
    }

    public static Vehicle createVehicle(String licensePlate, String vehicleMake, String vehicleModel, String vehicleColour, String vehicleVIN) {
        if (Helper.isNullorEmpty(licensePlate) ||
                Helper.isNullorEmpty(vehicleMake) ||
                Helper.isNullorEmpty(vehicleModel) ||
                Helper.isNullorEmpty(vehicleColour) ||
                Helper.isNullorEmpty(vehicleVIN)) {
            return null;
        }

        // Create the Vehicle without reservations
        return new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleMake(vehicleMake)
                .setVehicleModel(vehicleModel)
                .setVehicleColour(vehicleColour)
                .setVehicleVIN(vehicleVIN)
                .build();
    }

    // vehicle with no make
    public static Vehicle createVehicle(String licensePlate, String vehicleModel, String vehicleColour, Set<User> users, String vehicleVIN) {
        if (Helper.isNullorEmpty(licensePlate) ||
                Helper.isNullorEmpty(vehicleModel) ||
                Helper.isNullorEmpty(vehicleColour) ||
                Helper.isNullorEmpty(vehicleVIN) ||
                Helper.isNullorEmpty(users)) {
            return null;
        }

        // Create the Vehicle without reservations
        return new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleModel(vehicleModel)
                .setVehicleColour(vehicleColour)
                .setVehicleVIN(vehicleVIN)
                .setUsers(users)
                .build();
    }

    // vehicle with no colour
    public static Vehicle createVehicle(String licensePlate, String vehicleMake, String vehicleModel, String vehicleVIN, Set<User> users) {
        if (Helper.isNullorEmpty(licensePlate) ||
                Helper.isNullorEmpty(vehicleMake) ||
                Helper.isNullorEmpty(vehicleModel) ||
                Helper.isNullorEmpty(vehicleVIN) ||
                Helper.isNullorEmpty(users)) {
            return null;
        }

        // Create the Vehicle without reservations
        return new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleMake(vehicleMake)
                .setVehicleModel(vehicleModel)
                .setVehicleVIN(vehicleVIN)
                .setUsers(users)
                .build();
    }
}