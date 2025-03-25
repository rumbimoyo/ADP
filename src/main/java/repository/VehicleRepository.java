package repository;

import domain.Vehicle;

import java.util.Set;
import java.util.HashSet;

/* VehicleRepository.java
   Vehicle Repository class
   Author: Casey Abigail Nolte (218275161)
   Date: 21 March 2025
*/
public class VehicleRepository {
    private final Set<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new HashSet<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }

    public Vehicle findVehicleByLicensePlate(String licensePlate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    public boolean updateVehicle(Vehicle vehicle) {
        Vehicle existingVehicle = findVehicleByLicensePlate(vehicle.getLicensePlate());
        if (existingVehicle != null) {
            vehicles.remove(existingVehicle);
            vehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public boolean deleteVehicle(String licensePlate) {
        Vehicle vehicle = findVehicleByLicensePlate(licensePlate);
        if (vehicle != null) {
            vehicles.remove(vehicle);
            return true;
        }
        return false;
    }

    public Set<Vehicle> getAllVehicles() {
        return vehicles;
    }
}
