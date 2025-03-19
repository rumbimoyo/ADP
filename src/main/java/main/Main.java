package main;

import domain.*;
import factory.UserFactory;
import service.UserService;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // make your object from factory here

        User user = UserFactory.createUser("2309", "Bailey", 22,
                                     "081 888 0912", "Bailey@gmail.com");

        Vehicle vehicle = new Vehicle(); // testing
        Reservation reservation = new Reservation(); // testing

        UserService us = new UserService();


    }
}