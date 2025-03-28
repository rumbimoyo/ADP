package util;

/*
util.Helper
Helper class
Author: Sean Joel Bailey (230645682)
Date: 19/03/2025
 */

/*
util.Helper
Helper class with Reservation validation methods
Author: Avela Bonakali
Date: 20/03/2025
 */

import domain.*;
import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.util.Set;

public class Helper {

    public static Boolean isNullorEmpty(String string){return string  == null || string.equals("null") || string.trim().isEmpty();}

    public static Boolean isNullorEmpty(Integer number){
        return number == null || number == 0;
    }

    public static Boolean isNullorEmpty(Double number){
        return number == null || number == 0;
    }

    public static Boolean isNullorEmpty(LocalDate date){return date == null || date.equals(LocalDate.of(1970, 1, 1));}

    public static Boolean isNullorEmpty(ParkingLot parkingLot){return parkingLot == null;}

    public static Boolean isNullorEmpty(Vehicle vehicle){return vehicle == null;}

    public static Boolean isNullorEmpty(ParkingSpot parkingSpot){return parkingSpot == null;}

    public static Boolean isNullorEmpty(User user){return user == null;}

    public static Boolean isNullorEmpty(Set<User> users){return users.isEmpty();}

    public static Boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static Boolean isValidSpotNumber(int spotNumber){
        int length = String.valueOf(spotNumber).length();
        return length == 3;
    }

    public static Boolean isValidStatus(String status) {
        return status == null  ||
               status.equalsIgnoreCase("open")||
               status.equalsIgnoreCase("reserved")||
               status.equalsIgnoreCase("occupied");
    }

    public static Boolean isValidType(String type) {
        return type != null && (type.equalsIgnoreCase("compact") ||
                type.equalsIgnoreCase("disabled"));
    }

    public static boolean isValidTime(String time) {
        return time != null && time.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }



}

