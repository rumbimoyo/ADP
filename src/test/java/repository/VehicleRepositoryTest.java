package repository;

/*VehicleRepositoryTest.java
Vehicle Repository Test class
Author: Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

import domain.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryTest {
    private VehicleRepository repository;
    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        repository = VehicleRepository.getInstance(); // Use getInstance() if it's a Singleton
        vehicle = new Vehicle.Builder()
                .setLicensePlate("CA123456")
                .setVehicleMake("Toyota")
                .setVehicleModel("Corolla")
                .setVehicleColour("White")
                .setVehicleVIN("VIN12345")
                .build();
        repository.addVehicle(vehicle); // Ensure this method exists in VehicleRepository
    }

    @Test
    void addVehicle_Success() {
        assertTrue(repository.addVehicle(new Vehicle.Builder()
                .setLicensePlate("CA654321")
                .setVehicleMake("Honda")
                .setVehicleModel("Civic")
                .setVehicleColour("Black")
                .setVehicleVIN("VIN67890")
                .build()));
    }

    @Test
    void findVehicleByLicensePlate_ExistingVehicle_ReturnsVehicle() {
        Vehicle found = repository.findVehicleByLicensePlate("CA123456");
        assertNotNull(found);
        assertEquals("Toyota", found.getVehicleMake());
    }

    @Test
    void findVehicleByLicensePlate_NonExistentVehicle_ReturnsNull() {
        assertNull(repository.findVehicleByLicensePlate("NON_EXISTENT"));
    }

    @Test
    void updateVehicle_Success() {
        Vehicle updatedVehicle = new Vehicle.Builder()
                .setLicensePlate("CA123456")
                .setVehicleMake("Honda")
                .setVehicleModel("Civic")
                .setVehicleColour("Black")
                .setVehicleVIN("VIN54321")
                .build();

        assertTrue(repository.updateVehicle(updatedVehicle));
        Vehicle found = repository.findVehicleByLicensePlate("CA123456");

        assertNotNull(found);
        assertEquals("Honda", found.getVehicleMake());
        assertEquals("Civic", found.getVehicleModel());
        assertEquals("Black", found.getVehicleColour());
    }

    @Test
    void deleteVehicle_Success() {
        assertTrue(repository.deleteVehicle("CA123456"));
        assertNull(repository.findVehicleByLicensePlate("CA123456"));
    }

    @Test
    void getAllVehicles_ShouldReturnVehicles() {
        assertFalse(repository.getAllVehicles().isEmpty());
    }
}
