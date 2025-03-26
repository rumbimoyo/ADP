package repository;

import domain.Vehicle;
import java.util.HashMap;
import java.util.Map;

/* VehicleRepository.java
   Vehicle Repository class
   Author: Casey Abigail Nolte (218275161)
   Date: 21 March 2025
*/

public class VehicleRepository {
    private static VehicleRepository repository = null;
    private Map<String, Vehicle> vehicleMap;

    private VehicleRepository() { // Private constructor to enforce Singleton pattern
        vehicleMap = new HashMap<>();
    }

    public static VehicleRepository getInstance() {
        if (repository == null) {
            repository = new VehicleRepository();
        }
        return repository;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle == null || vehicleMap.containsKey(vehicle.getLicensePlate())) {
            return false;
        }
        vehicleMap.put(vehicle.getLicensePlate(), vehicle);
        return true;
    }

    public Vehicle findVehicleByLicensePlate(String licensePlate) {
        return vehicleMap.get(licensePlate);
    }

    public boolean updateVehicle(Vehicle vehicle) {
        if (vehicle == null || !vehicleMap.containsKey(vehicle.getLicensePlate())) {
            return false;
        }
        vehicleMap.put(vehicle.getLicensePlate(), vehicle);
        return true;
    }

    public boolean deleteVehicle(String licensePlate) {
        return vehicleMap.remove(licensePlate) != null;
    }

    public Map<String, Vehicle> getAllVehicles() {
        return vehicleMap;
    }
}