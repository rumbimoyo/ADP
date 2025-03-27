package repository;

/*VehicleRepositoryTest.java
Vehicle Repository Test class
Author: Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

import domain.User;
import domain.Vehicle;
import factory.UserFactory;
import factory.VehicleFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryTest {

    private User user1 = UserFactory.createUser("811", "Sean Bailey", LocalDate.of(2001, 9,9), "male", "081-222-1111", "sean@gmail.com");
    private User user2 = UserFactory.createUser("2673", "John", LocalDate.of(2004,9, 9), "male", "081-234-0192", "john@gmail.com");

    Set<User> users = new HashSet<>();

    private VehicleRepository repository;
    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
<<<<<<< HEAD
        repository = VehicleRepository.getInstance(); // Use getInstance() if it's a Singleton
        vehicle = new Vehicle.Builder()
                .setLicensePlate("CA123456")
                .setVehicleMake("Toyota")
                .setVehicleModel("Corolla")
                .setVehicleColour("White")
                .setVehicleVIN("VIN12345")
                .build();
        repository.addVehicle(vehicle); // Ensure this method exists in VehicleRepository
=======
        repository = VehicleRepository.getInstance();
        users.add(user1);
        users.add(user2);
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "Red", "VIN123456", users);
        repository.create(vehicle);
>>>>>>> 15432b20a5645b31a81de9ece588a84dcc9628cb
    }


    @Test
<<<<<<< HEAD
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
=======
    @Order(1)
    void create_Success() {
        assertNotNull(repository.read("CA123456"));
    }

    @Test
    @Order(2)
    void read_NonExistentVehicle_ReturnsNull() {
        assertNull(repository.read("NON_EXISTENT"));
    }


    @Test
    @Order(3)
    void update_Success() {
        Vehicle updatedVehicle = VehicleFactory.createVehicle("CA123456", "Honda", "Civic", "Black", "VIN123456", users);

        assert updatedVehicle != null;
        repository.update(updatedVehicle);
        Vehicle found = repository.read("CA123456");
>>>>>>> 15432b20a5645b31a81de9ece588a84dcc9628cb

        assertNotNull(found);
        assertEquals("Honda", found.getVehicleMake());
        assertEquals("Civic", found.getVehicleModel());
        assertEquals("Black", found.getVehicleColour());
    }

    @Test
<<<<<<< HEAD
    void deleteVehicle_Success() {
        assertTrue(repository.deleteVehicle("CA123456"));
        assertNull(repository.findVehicleByLicensePlate("CA123456"));
=======
    @Order(4)
    void delete_Success() {
        Vehicle vehicle = VehicleFactory.createVehicle("CA11111", "Toyota", "Corolla", "Red", "VIN123456", users);
        repository.create(vehicle);

        repository.delete("CA11111");

        assertNull(repository.read("CA11111"));
>>>>>>> 15432b20a5645b31a81de9ece588a84dcc9628cb
    }


    @Test
<<<<<<< HEAD
    void getAllVehicles_ShouldReturnVehicles() {
        assertFalse(repository.getAllVehicles().isEmpty());
=======
    @Order(5)
    void getAll_ShouldReturnVehicles() {
        assertFalse(repository.getAll().isEmpty());
>>>>>>> 15432b20a5645b31a81de9ece588a84dcc9628cb
    }
}
