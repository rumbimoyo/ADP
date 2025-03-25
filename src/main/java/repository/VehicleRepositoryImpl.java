package repository;

/*Vehicle.java
Vehicle Repository Implementation class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

import domain.Vehicle;

import java.util.HashSet;
import java.util.Set;

public class VehicleRepositoryImpl implements VehicleRepository {
    private final Set<Vehicle> vehicleDB;
    private static VehicleRepositoryImpl repository = null;

    private VehicleRepositoryImpl() {
        this.vehicleDB = new HashSet<>();
    }

    public static VehicleRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new VehicleRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicleDB.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle read(String licensePlate) {
        return vehicleDB.stream()
                .filter(v -> v.getLicensePlate().equals(licensePlate))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Vehicle update(Vehicle updatedVehicle) {
        Vehicle existingVehicle = read(updatedVehicle.getLicensePlate());
        if (existingVehicle != null) {
            vehicleDB.remove(existingVehicle);
            vehicleDB.add(updatedVehicle);
            return updatedVehicle;
        }
        return null;
    }

    @Override
    public boolean delete(String licensePlate) {
        Vehicle vehicleToDelete = read(licensePlate);
        if (vehicleToDelete != null) {
            vehicleDB.remove(vehicleToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<Vehicle> getAll() {
        return vehicleDB;
    }
}

