package za.ac.cput.repository.impl;

import za.ac.cput.domain.Vehicle;
import za.ac.cput.repository.VehicleRepository;

import java.util.HashSet;
import java.util.Set;

/*VehicleRepositoryImplementation.java
Vehicle Repository Implementation class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

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
        Vehicle vehicle = read(licensePlate);
        if (vehicle != null) {
            vehicleDB.remove(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public Set<Vehicle> getAll() {
        return vehicleDB;
    }
}//end of class
