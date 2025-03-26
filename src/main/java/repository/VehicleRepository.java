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

    public boolean create(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }


    public Vehicle read(String licensePlate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    public boolean update(Vehicle vehicle) {
        Vehicle existingVehicle = read(vehicle.getLicensePlate());
        if (existingVehicle != null) {
            vehicles.remove(existingVehicle);
            vehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public boolean delete(String licensePlate) {
        Vehicle vehicle = read(licensePlate);
        if (vehicle != null) {
            vehicles.remove(vehicle);
            return true;
        }
        return false;
    }

    public Set<Vehicle> getAll() {
        return vehicles;
    }
}
