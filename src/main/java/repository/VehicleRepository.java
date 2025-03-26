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
    private static VehicleRepository instance;
    private final Set<Vehicle> vehicles = new HashSet<>();

    private VehicleRepository() {} // Private constructor

    public static synchronized VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance; // Returns singleton instance
    }

    public boolean add(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }

    public Vehicle findByLicensePlate(String licensePlate) {
        return vehicles.stream()
                .filter(v -> v.getLicensePlate().equals(licensePlate))
                .findFirst()
                .orElse(null);
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
