package repository;

/*
test.repository.UserRepositoryTest
UserFactoryTest class
Author: Sean Joel Bailey (230645682)
Date: 18/03/2025
 */

import domain.Reservation;
import domain.User;
import domain.Vehicle;
import factory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository = UserRepository.getInstance();

    private final Set<Reservation> reservations = new HashSet<>();
    private final Set<Vehicle> vehicles = new HashSet<>();

    User user = UserFactory.createUser("2673", "TEST", 31, "081 324 5689", "john@gmail.com", vehicles, reservations);

    @Test
    @DisplayName("Testing of instance method")
    void getInstance() {
        UserRepository newUser = UserRepository.getInstance();
        assertNotNull(userRepository);
        assertSame(userRepository, newUser, "Must be same instance of class");
    }

    @Test
    @DisplayName("Testing create method")
    void create(){
        boolean check = userRepository.create(user);
        assertTrue(check, "should be true");

        check = userRepository.create(user);
        assertFalse(check, "should be false, duplicate should not be added");
    }

   @Test
   @DisplayName("Testing read method")
   void read() {
        User user1 = userRepository.read("2673");
        assertEquals(user1.getUserID(), user.getUserID(), "Should be the same");
    }

    @Test
    @DisplayName("Testing if read returns null")
    void readNull() {
        User user1 = userRepository.read("2671");
        assertNull(user1, "Should be null");
    }

    @Test
    @DisplayName("Testing update method")
    void update() {
        // newUser does not have reservations and vehicles
        User newUser = UserFactory.createUser("2673", "TEST", 31, "081 324 5689", "john@gmail.com");
        newUser = userRepository.update(newUser);

        assertNotNull(newUser, "If successful, should not be null");
        assertNull(newUser.getReservations(), "New object does not have reservations so should be null");
    }

    @Test
    @DisplayName("Testing if update returns null")
    void updateNull() {
        // newUser does not exist in repository
        User newUser = UserFactory.createUser("0", "TEST", 31, "081 324 5689", "john@gmail.com");
        newUser = userRepository.update(newUser);

        assertNull(newUser, "Should be null");
    }

    @Test
    @DisplayName("Testing if delete works")
    void delete() {
        User newUser = UserFactory.createUser("6661", "TEST", 31, "081 324 5689", "john@gmail.com");
        userRepository.create(newUser);

        userRepository.delete("6661");
        User user = userRepository.read("6661");
        assertNull(user, "Object should be deleted from db");
    }

    @Test
    @DisplayName("Testing if delete returns null if object not in database")
    void deleteNull() {
        userRepository.delete("0000");
        User user = userRepository.read("0000");
        assertNull(user, "Object should not exist");

    }

    @Test
    @DisplayName("Testing getAll methods")
    void getAll() {
        Set<User> users = userRepository.getAll();
        Set<User> user1 = userRepository.getAll();

        assertSame(users, user1, "Should be the same");

        for(User user2 : users) {
            assertTrue(user2 instanceof User, "Should be instance of class User");
        }
    }
}