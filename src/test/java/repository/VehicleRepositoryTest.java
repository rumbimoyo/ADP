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
        repository = VehicleRepository.getInstance();
        users.add(user1);
        users.add(user2);
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "Red", "VIN123456", users);
        repository.create(vehicle);
    }


    @Test
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

        assertNotNull(found);
        assertEquals("Honda", found.getVehicleMake());
        assertEquals("Civic", found.getVehicleModel());
        assertEquals("Black", found.getVehicleColour());
    }

    @Test
    @Order(4)
    void delete_Success() {
        Vehicle vehicle = VehicleFactory.createVehicle("CA11111", "Toyota", "Corolla", "Red", "VIN123456", users);
        repository.create(vehicle);

        repository.delete("CA11111");

        assertNull(repository.read("CA11111"));
    }


    @Test
    @Order(5)
    void getAll_ShouldReturnVehicles() {
        assertFalse(repository.getAll().isEmpty());
    }
}