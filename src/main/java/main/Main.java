package main;

import domain.*;
import factory.UserFactory;
import service.UserService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        User user = UserFactory.createUser("2673", "John", LocalDate.of(2004,9, 9), "male", "081-234-0192", "john@gmail.com");

        userService.addUser(user);



    }


}