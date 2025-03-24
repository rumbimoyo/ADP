package factory;

import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.repository.impl.VehicleRepositoryImpl;

import org.junit.jupiter.api.Test;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/*factory.VehicleTest.java
Vehicle Test class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

class VehicleTest {
    @Test
    void testVehicleCreation() {
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla",
                "Red", "VIN123456", new HashSet<>(), new HashSet<>());

        assertNotNull(vehicle);
        assertEquals("Toyota", vehicle.getVehicleMake());
        assertEquals("Corolla", vehicle.getVehicleModel());
        assertEquals("Red", vehicle.getVehicleColour());
    }
}//end of class
