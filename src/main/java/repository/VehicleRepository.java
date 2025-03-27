package repository;

import domain.Vehicle;
import java.util.HashMap;
import java.util.Map;

/* VehicleRepository.java
   Vehicle Repository class
   Author: Casey Abigail Nolte (218275161)
   Date: 21 March 2025
*/
<<<<<<< HEAD

public class VehicleRepository {
    private static VehicleRepository repository = null;
    private Map<String, Vehicle> vehicleMap;
=======
public class VehicleRepository implements IRepository<Vehicle, String>{
    private static VehicleRepository instance;
    private final Set<Vehicle> vehicles = new HashSet<>();
>>>>>>> 15432b20a5645b31a81de9ece588a84dcc9628cb

    private VehicleRepository() { // Private constructor to enforce Singleton pattern
        vehicleMap = new HashMap<>();
    }

    public static VehicleRepository getInstance() {
        if (repository == null) {
            repository = new VehicleRepository();
        }
        return repository;
    }

<<<<<<< HEAD
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
=======
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

    public Vehicle update(Vehicle vehicle) {
        Vehicle existingVehicle = read(vehicle.getLicensePlate());
        if (existingVehicle != null) {
            vehicles.remove(existingVehicle);
            vehicles.add(vehicle);
            return existingVehicle;
        }
        return null;
    }

    public void delete(String licensePlate) {
        Vehicle vehicle = read(licensePlate);
        if (vehicle != null) {
            vehicles.remove(vehicle);
        }
    }

    public Set<Vehicle> getAll() {
        return vehicles;
>>>>>>> 15432b20a5645b31a81de9ece588a84dcc9628cb
    }
}