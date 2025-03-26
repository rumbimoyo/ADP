package util;

/*
util.Helper
Helper class
Author: Sean Joel Bailey (230645682)
Date: 19/03/2025
 */


import domain.*;
        import org.apache.commons.validator.routines.EmailValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Helper {

    // Existing methods
    public static Boolean isNullorEmpty(String attribute) {
        return attribute == null || attribute.equals("null") || attribute.trim().isEmpty();
    }


    public static <Int> Boolean isNullorEmpty(Int spotNumber) {
        return spotNumber == null;
    }

    public static Boolean isNullorEmptyDate(LocalDate date) {
        return date == null || date.equals(LocalDate.of(1970, 1, 1));
    }

    public static Boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
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
}




