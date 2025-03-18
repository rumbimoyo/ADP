package factory;

/*
test.factory.UserFactoryTest
UserFactoryTest class
Author: Sean Joel Bailey (230645682)
Date: 18/03/2025
 */

import domain.Reservation;
import domain.User;
import domain.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    private User user;

    private final Set<Reservation> reservations = new HashSet<>();
    private final Set<Vehicle> vehicles = new HashSet<>();

    @Test
    @DisplayName("UserFactory test of all attributes")
    void createUserFactory() {
       user = UserFactory.createUser("2673", "John", 31, "081 324 5689", "john@gmail.com", vehicles, reservations);
       assertNotNull(user, "Should be an object of user class");
       assertInstanceOf(User.class, user, "should be an instance of user class");
       assertEquals("2673", user.getUserID(), "should be 2673");
    }

    @Test
    @DisplayName("UserFactory test, excludes reservations")
    void createUserFactory1() {
        user = UserFactory.createUser("2012","patric", 29,"071 921 0191",vehicles,"patrick@gmail.com");
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2012", user.getUserID(), "should be 2012");
    }

    @Test
    @DisplayName("UserFactory test, excludes vehicles")
    void createUserFactory2() {
        user = UserFactory.createUser("2001","james", 19,"072 333 0192","patrick@gmail.com", reservations);
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2001", user.getUserID(), "should be 2001");
    }

    @Test
    @DisplayName("UserFactory test, excludes vehicles and reservations ")
    void createUserFactory3() {
        user = UserFactory.createUser("2911", "Sam", 20, "081 324 2031", "sam@outlook.com");
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2911", user.getUserID(), "should be 2911");
    }

    @Test
    @DisplayName("UserFactory test, excludes contact number")
    void createUserFactory4() {
        user = UserFactory.createUser("2088", "Augustus", 20, "Augw12@outlook.com", vehicles, reservations);
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2088", user.getUserID(), "should be 2088");
    }

    @Test
    @DisplayName("UserFactory test, excludes contact number and vehicle")
    void createUserFactory5() {
        user = UserFactory.createUser("2212", "Mark", 23, "ManyMen22@outlook.com", reservations);
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2212", user.getUserID(), "should be 2212");
    }

    @Test
    @DisplayName("UserFactory test, excludes contact number and reservation")
    void createUserFactory6() {
        user = UserFactory.createUser("2515", "Debbie", 29, vehicles, "debborah@gmail.com");
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2515", user.getUserID(), "should be 2515");
    }







}