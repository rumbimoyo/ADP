package repository;

/*VehicleRepositoryTest.java
Vehicle Repository Test class
Author:Casey Abigail Nolte (218275161)
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
        repository = VehicleRepositoryImpl.getRepository();
        vehicle = new Vehicle.Builder()
                .setLicensePlate("CA123456")
                .setVehicleMake("Toyota")
                .setVehicleModel("Corolla")
                .setVehicleColour("White")
                .setVehicleVIN("VIN12345")
                .build();
        repository.create(vehicle);
    }

    @Test
    void create_Success() {
        assertNotNull(repository.read("CA123456"));
    }

    @Test
    void read_ExistingVehicle_ReturnsVehicle() {
        Vehicle found = repository.read("CA123456");
        assertNotNull(found);
        assertEquals("Toyota", found.getVehicleMake());
    }

    @Test
    void read_NonExistentVehicle_ReturnsNull() {
        assertNull(repository.read("NON_EXISTENT"));
    }

    @Test
    void update_Success() {
        Vehicle updatedVehicle = new Vehicle.Builder()
                .setLicensePlate("CA123456")
                .setVehicleMake("Honda")
                .setVehicleModel("Civic")
                .setVehicleColour("Black")
                .setVehicleVIN("VIN54321")
                .build();

        repository.update(updatedVehicle);
        Vehicle found = repository.read("CA123456");

        assertNotNull(found);
        assertEquals("Honda", found.getVehicleMake());
        assertEquals("Civic", found.getVehicleModel());
        assertEquals("Black", found.getVehicleColour());
    }

    @Test
    void delete_Success() {
        assertTrue(repository.delete("CA123456"));
        assertNull(repository.read("CA123456"));
    }

    @Test
    void getAll_ShouldReturnVehicles() {
        assertFalse(repository.getAll().isEmpty());
    }
}//end of class