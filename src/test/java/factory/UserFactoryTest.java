package factory;

/*
test.factory.UserFactoryTest
UserFactoryTest class
Author: Sean Joel Bailey (230645682)
Date: 18/03/2025
 */

import domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    private User user;

    @Test
    @DisplayName("UserFactory test of all attributes")
    void createUserFactory() {
       user = UserFactory.createUser("2673", "John", LocalDate.of(2004,9, 9), "male", "081-234-0192", "john@gmail.com");
       assertNotNull(user, "Should be an object of user class");
       assertInstanceOf(User.class, user, "should be an instance of user class");
       assertEquals("2673", user.getUserID(), "should be 2673");
    }

    @Test
    @DisplayName("UserFactory test, excludes contact numbers")
    void createUserFactory1() {
        user = UserFactory.createUser("2012","patric", LocalDate.of(2005,2,1), "female","patrick@gmail.com");
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2012", user.getUserID(), "should be 2012");
    }

    @Test
    @DisplayName("UserFactory test, excludes gender")
    void createUserFactory2() {
        user = UserFactory.createUser("2001","james", "james@gmail.com", LocalDate.of(1999,1,2), "081-201-2990");
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2001", user.getUserID(), "should be 2001");
    }

    @Test
    @DisplayName("UserFactory test, excludes contact number and gender")
    void createUserFactory3() {
        user = UserFactory.createUser("2911", "Sam", LocalDate.of(2001,1, 1), "sam@outlook.com");
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2911", user.getUserID(), "should be 2911");
    }

    @Test
    @DisplayName("UserFactory test, excludes email")
    void createUserFactory4() {
        user = UserFactory.createUser("2673", LocalDate.of(2004,9, 9), "John","male", "081-234-0192");
        assertNotNull(user, "Should be an object of user class");
        assertInstanceOf(User.class, user, "should be an instance of user class");
        assertEquals("2673", user.getUserID(), "should be 2673");
    }

}