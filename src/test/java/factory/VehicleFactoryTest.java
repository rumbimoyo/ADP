package factory;


import domain.User;
import domain.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*factory.VehicleTest.java
Vehicle Test class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

class VehicleFactoryTest {
    private User user1 = UserFactory.createUser("811", "Sean Bailey", LocalDate.of(2001, 9,9), "male", "081-222-1111", "sean@gmail.com");
    private User user2 = UserFactory.createUser("2673", "John", LocalDate.of(2004,9, 9), "male", "081-234-0192", "john@gmail.com");

    Set<User> users = new HashSet<>();


    @Test
    @DisplayName("Vehicle with all attributes")
    void createVehicle() {
        users.add(user1);
        users.add(user2);
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "Red", "VIN123456", users);

        assertNotNull(vehicle);
        assertEquals("Toyota", vehicle.getVehicleMake());
        assertEquals("Corolla", vehicle.getVehicleModel());
        assertEquals("Red", vehicle.getVehicleColour());
    }

    @Test
    @DisplayName("Vehicle with no make")
    void testCreateVehicle() {
        users.add(user1);
        users.add(user2);
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Corolla", "Red", users, "VIN123456");

        assertNotNull(vehicle);
        assertNull(vehicle.getVehicleMake(), "should be null");
        assertEquals("Corolla", vehicle.getVehicleModel());
        assertEquals("Red", vehicle.getVehicleColour());
    }

    @Test
    @DisplayName("Vehicle with no color")
    void testCreateVehicle1() {
        users.add(user1);
        users.add(user2);
        Vehicle vehicle = VehicleFactory.createVehicle("CA123456", "Toyota", "Corolla", "VIN123456", users);

        assertNotNull(vehicle);
        assertEquals("Toyota", vehicle.getVehicleMake());
        assertEquals("Corolla", vehicle.getVehicleModel());
        assertNull(vehicle.getVehicleColour(), "should be null");
    }

}
