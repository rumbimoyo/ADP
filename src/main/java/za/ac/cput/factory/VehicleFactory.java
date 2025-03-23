package za.ac.cput.factory;

import za.ac.cput.domain.Vehicle;

import java.util.Set;

/*VehicleFactory.java
Vehicle Factory class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

public class VehicleFactory {
    public static Vehicle createVehicle(String licensePlate, String vehicleMake, String vehicleModel,
                                        String vehicleColour, String vehicleVIN,
                                        Set<String> tickets, Set<String> reservations) {
        return new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleMake(vehicleMake)
                .setVehicleModel(vehicleModel)
                .setVehicleColour(vehicleColour)
                .setVehicleVIN(vehicleVIN)
                .setTickets(tickets)
                .setReservations(reservations)
                .build();
    }
}//end of class
