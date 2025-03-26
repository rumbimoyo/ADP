package repository;

/*VehicleRepositoryTest.java
Vehicle Repository Test class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

import domain.User;
import domain.Vehicle;
import factory.UserFactory;
import factory.VehicleFactory;
import org.junit.jupiter.api.BeforeEach;
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
        repository = VehicleRepository.getInstance();
        users.add(user1);
        users.add(user2);
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "Red", "VIN123456", users);
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
        Vehicle updatedVehicle = VehicleFactory.createVehicle("CA123456", "Honda", "Civic", "Black", "VIN123456", users);

        assert updatedVehicle != null;
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
}