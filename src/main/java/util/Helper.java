package util;

/*
util.Helper
Helper class
Author: Sean Joel Bailey (230645682)
Date: 19/03/2025
 */

import domain.Reservation;
import domain.Vehicle;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.HashSet;
import java.util.Set;

public class Helper {

    public static Boolean isNullorEmpty(String attribute){
        return attribute.equals("null") || attribute.trim().isEmpty();
    }

    public static Boolean isNullorEmpty(Integer number){
        return number == null;
    }

    public static Boolean isNullorEmptyReservation(Set<Reservation> reservations){
        return reservations.isEmpty();
    }

    public static Boolean isNullorEmptyVehicle(Set<Vehicle> vehicles){
        return vehicles.isEmpty();
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

}
