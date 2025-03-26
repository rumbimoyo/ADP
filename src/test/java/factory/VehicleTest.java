package factory;

/* VehicleFactoryTest.java
   Vehicle Factory Test class
   Author: Casey Abigail Nolte (218275161)
   Date: 21 March 2025
*/

import domain.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {

    @Test
    void createVehicle_Success() {
        Vehicle vehicle = VehicleFactory.createVehicle(
                "CA123456", "Toyota", "Corolla", "White", "VIN12345"
        );

        assertNotNull(vehicle);
        assertEquals("CA123456", vehicle.getLicensePlate());
        assertEquals("Toyota", vehicle.getVehicleMake());
        assertEquals("Corolla", vehicle.getVehicleModel());
        assertEquals("White", vehicle.getVehicleColour());
        assertEquals("VIN12345", vehicle.getVehicleVIN());
    }

    @Test
    void createVehicle_WithNullValues_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            VehicleFactory.createVehicle(null, "Toyota", "Corolla", "White", "VIN12345");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            VehicleFactory.createVehicle("CA123456", "", "Corolla", "White", "VIN12345");
        });
    }
}
