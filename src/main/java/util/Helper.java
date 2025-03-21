package util;

/*
util.Helper
Helper class
Author: Sean Joel Bailey (230645682)
Date: 19/03/2025
 */

import domain.ParkingLot;
import domain.ParkingSpot;
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
    public static Boolean isNullOrEmpty(String attribute) {
        return attribute == null || attribute.trim().isEmpty();
    }


    public static Boolean isNullOrZero(Integer number) {
        return number == null || number == 0;
    }


    public static Boolean isNullOrEmpty(ParkingLot parkingLot) {
        return parkingLot == null;
    }


    public static Boolean isValidStatus(String status) {
        return status != null && (
                status.equalsIgnoreCase("open") ||
                        status.equalsIgnoreCase("reserved") ||
                        status.equalsIgnoreCase("occupied"));
    }


    public static Boolean isValidType(String type) {
        return type != null && (type.equalsIgnoreCase("compact") ||
                type.equalsIgnoreCase("disabled"));
    }


    public static Boolean isNullOrEmptySet(Set<?> set) {
        return set == null || set.isEmpty();
    }
}


