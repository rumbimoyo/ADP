package factory;

import domain.Vehicle;
import domain.ParkingLot;
import domain.ParkingSpot;
import util.Helper;

/* VehicleFactory.java
   Vehicle Factory class
   Author: Casey Abigail Nolte (218275161)
   Date: 21 March 2025
*/

public class VehicleFactory {


    public static Vehicle createVehicle(String licensePlate, String vehicleMake, String vehicleModel,
                                        String vehicleColour, String vehicleVIN, ParkingLot parkingLot,
                                        ParkingSpot parkingSpot) {
        if (Helper.isNullorEmpty(licensePlate) || Helper.isNullorEmpty(vehicleMake) ||
                Helper.isNullorEmpty(vehicleModel) || Helper.isNullorEmpty(vehicleColour) ||
                Helper.isNullorEmpty(vehicleVIN) || parkingLot == null || parkingSpot == null) {
            throw new IllegalArgumentException("Invalid vehicle parameters.");
        }

        return new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleMake(vehicleMake)
                .setVehicleModel(vehicleModel)
                .setVehicleColour(vehicleColour)
                .setVehicleVIN(vehicleVIN)
                .build();
    }


    public static Vehicle createVehicle(String licensePlate, String vehicleMake, String vehicleModel,
                                        String vehicleColour, String vehicleVIN) {
        if (Helper.isNullorEmpty(licensePlate) || Helper.isNullorEmpty(vehicleMake) ||
                Helper.isNullorEmpty(vehicleModel) || Helper.isNullorEmpty(vehicleColour) ||
                Helper.isNullorEmpty(vehicleVIN)) {
            throw new IllegalArgumentException("Invalid vehicle parameters.");
        }

        return new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleMake(vehicleMake)
                .setVehicleModel(vehicleModel)
                .setVehicleColour(vehicleColour)
                .setVehicleVIN(vehicleVIN)
                .build();
    }
}