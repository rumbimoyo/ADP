package za.ac.cput;

import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.repository.impl.VehicleRepositoryImpl;

import java.util.HashSet;

/*Main.java
Main class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("---Automated Parking Lot System Started.---");

        // Create an instance of the repository
        VehicleRepositoryImpl vehicleRepository = VehicleRepositoryImpl.getRepository();

        // Create a vehicle using the factory
        Vehicle vehicle1 = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla",
                "White", "VIN123456", new HashSet<>(), new HashSet<>());

        Vehicle vehicle2 = VehicleFactory.createVehicle("CA654321", "Honda", "Civic",
                "Red", "VIN654321", new HashSet<>(), new HashSet<>());

        // Store vehicles in the repository
        vehicleRepository.create(vehicle1);
        vehicleRepository.create(vehicle2);

        // Display all vehicles
        System.out.println("--All Vehicles in System:--");
        vehicleRepository.getAll().forEach(System.out::println);

        // Search for a specific vehicle
        System.out.println("-Searching for vehicle with License Plate CA123456...-");
        Vehicle foundVehicle = vehicleRepository.read("CA123456");
        if (foundVehicle != null) {
            System.out.println("Vehicle Found: " + foundVehicle);
        } else {
            System.out.println("Vehicle Not Found.");
        }

        // Update a vehicle
        System.out.println("-Updating Vehicle CA123456...-");
        Vehicle updatedVehicle = new Vehicle.Builder()
                .setLicensePlate("CA123456")
                .setVehicleMake("Toyota")
                .setVehicleModel("Corolla Cross")
                .setVehicleColour("Blue")
                .setVehicleVIN("VIN123456")
                .setTickets(new HashSet<>())
                .setReservations(new HashSet<>())
                .build();

        vehicleRepository.update(updatedVehicle);
        System.out.println("Updated Vehicle: " + vehicleRepository.read("CA123456"));

        // Delete a vehicle
        System.out.println("-Removing Vehicle CA654321...-");
        boolean deleted = vehicleRepository.delete("CA654321");
        System.out.println(deleted ? "Vehicle deleted!" : "Deletion failed.");

        // Display remaining vehicles
        System.out.println("-Remaining Vehicles:--");
        vehicleRepository.getAll().forEach(System.out::println);

        System.out.println("---Automated Parking Lot System Ended.---");
    }
} // end of class//end of class