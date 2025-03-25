package repository;

/*Vehicle.java
Vehicle Repository Implementation class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

import domain.Vehicle;

import java.util.HashSet;
import java.util.Set;

/*Vehicle.java
Vehicle Repository class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

public interface VehicleRepository {
    Vehicle create(Vehicle vehicle);
    Vehicle read(String licensePlate);
    Vehicle update(Vehicle vehicle);
    boolean delete(String licensePlate);
    Set<Vehicle> getAll();
}//end of class
