//package util;
//
///*
//util.Helper
//Helper class
//Author: Sean Joel Bailey (230645682)
//Date: 19/03/2025
// */
//
//import domain.ParkingLot;
//import domain.ParkingSpot;
//import domain.Reservation;
//import domain.Vehicle;
//import org.apache.commons.validator.routines.EmailValidator;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class Helper {
//
//    public static Boolean isNullorEmpty(String attribute){
//        return attribute.equals("null") || attribute.trim().isEmpty();
//    }
//
//    public static Boolean isNullorEmpty(Integer number){
//        return number == null;
//    }
//
//    public static Boolean isNullorEmptyReservation(Set<Reservation> reservations){
//        return reservations.isEmpty();
//    }
//
//    public static Boolean isNullorEmptyVehicle(Set<Vehicle> vehicles){
//        return vehicles.isEmpty();
//    }
//
//    public static boolean isValidEmail(String email) {
//        EmailValidator validator = EmailValidator.getInstance();
//        return validator.isValid(email);
//    }
//    public static Boolean isNullOrEmpty(String attribute) {
//        return attribute == null || attribute.trim().isEmpty();
//    }
//
//
//    public static Boolean isNullOrZero(Integer number) {
//        return number == null || number == 0;
//    }
//
//
//    public static Boolean isNullOrEmpty(ParkingLot parkingLot) {
//        return parkingLot == null;
//    }
//
//
//    public static Boolean isValidStatus(String status) {
//        return status != null && (
//                status.equalsIgnoreCase("open") ||
//                        status.equalsIgnoreCase("reserved") ||
//                        status.equalsIgnoreCase("occupied"));
//    }
//
//
//    public static Boolean isValidType(String type) {
//        return type != null && (type.equalsIgnoreCase("compact") ||
//                type.equalsIgnoreCase("disabled"));
//    }
//
//
//    public static Boolean isNullOrEmptySet(Set<?> set) {
//        return set == null || set.isEmpty();
//    }
//}
package util;

/*
util.Helper
Helper class with Reservation validation methods
Author: Avela Bonakali
Date: 20/03/2025
 */

import domain.*;
        import org.apache.commons.validator.routines.EmailValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Helper {

    // Existing methods
    public static Boolean isNullorEmpty(String attribute){
        return attribute == null || attribute.equals("null") || attribute.trim().isEmpty();
    }

    public static Boolean isNullorEmpty(Integer number){
        return number == null;
    }

    public static Boolean isNullorEmptyReservation(Set<Reservation> reservations){
        return reservations == null || reservations.isEmpty();
    }

    public static Boolean isNullorEmptyVehicle(Set<Vehicle> vehicles){
        return vehicles == null || vehicles.isEmpty();
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

    // New methods for Reservation validation

    /**
     * Validates that the time string is in correct format (HH:MM)
     * @param time Time string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidTimeFormat(String time) {
        if (isNullorEmpty(time)) {
            return false;
        }

        // Regex pattern for HH:MM format (24-hour clock)
        String pattern = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        return Pattern.matches(pattern, time);
    }

    /**
     * Validates that endTime is after startTime
     * @param startTime Start time string (HH:MM)
     * @param endTime End time string (HH:MM)
     * @return true if valid time range, false otherwise
     */
    public static boolean isValidTimeRange(String startTime, String endTime) {
        if (!isValidTimeFormat(startTime) || !isValidTimeFormat(endTime)) {
            return false;
        }

        return startTime.compareTo(endTime) < 0;
    }

    /**
     * Validates that a price is positive
     * @param price Price to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidPrice(double price) {
        return price >= 0.0;
    }

    /**
     * Validates a date is not in the past
     * @param date Date to validate
     * @return true if valid, false otherwise
     */
    public static boolean isDateNotInPast(Date date) {
        if (date == null) {
            return false;
        }

        Date now = new Date();
        return !date.before(now);
    }

    /**
     * Validates that a date string is in correct format (yyyy-MM-dd)
     * @param dateStr Date string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidDateFormat(String dateStr) {
        if (isNullorEmpty(dateStr)) {
            return false;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);

        try {
            format.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Validates that a reservation ID is in the correct format (RES-XXXXX)
     * @param reservationID ID to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidReservationID(String reservationID) {
        if (isNullorEmpty(reservationID)) {
            return false;
        }

        // Regex pattern for RES-XXXXX where X is alphanumeric
        String pattern = "^RES-[A-Za-z0-9]{5,}$";
        return Pattern.matches(pattern, reservationID);
    }

    /**
     * Validates the complete Reservation object
     * @param reservation Reservation to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidReservation(Reservation reservation) {
        if (reservation == null) {
            return false;
        }

        // Check all required fields
        if (isNullorEmpty(reservation.getReservationID()) ||
                isNullorEmpty(reservation.getStartTime()) ||
                isNullorEmpty(reservation.getEndTime()) ||
                reservation.getDate() == null ||
                reservation.getParkingSpot() == null) {
            return false;
        }

        // Validate ID format
        if (!isValidReservationID(reservation.getReservationID())) {
            return false;
        }

        // Validate time formats
        if (!isValidTimeFormat(reservation.getStartTime()) ||
                !isValidTimeFormat(reservation.getEndTime())) {
            return false;
        }

        // Validate time range
        if (!isValidTimeRange(reservation.getStartTime(), reservation.getEndTime())) {
            return false;
        }

        // Validate price
        if (!isValidPrice(reservation.getPrice())) {
            return false;
        }

        // Validate date not in past
        if (!isDateNotInPast(reservation.getDate())) {
            return false;
        }

        return true;
    }

    /**
     * Checks if two time ranges overlap
     * @param start1 Start time of first range (HH:MM)
     * @param end1 End time of first range (HH:MM)
     * @param start2 Start time of second range (HH:MM)
     * @param end2 End time of second range (HH:MM)
     * @return true if ranges overlap, false otherwise
     */
    public static boolean doTimeRangesOverlap(String start1, String end1, String start2, String end2) {
        // Make sure all inputs are valid
        if (!isValidTimeFormat(start1) || !isValidTimeFormat(end1) ||
                !isValidTimeFormat(start2) || !isValidTimeFormat(end2)) {
            return false;
        }

        // Check if ranges overlap
        return start1.compareTo(end2) < 0 && start2.compareTo(end1) < 0;
    }

    /**
     * Calculate duration between two times in hours
     * @param startTime Start time (HH:MM)
     * @param endTime End time (HH:MM)
     * @return Duration in hours or -1 if invalid input
     */
    public static double calculateDurationInHours(String startTime, String endTime) {
        if (!isValidTimeFormat(startTime) || !isValidTimeFormat(endTime) ||
                !isValidTimeRange(startTime, endTime)) {
            return -1;
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date start = format.parse(startTime);
            Date end = format.parse(endTime);

            // Calculate difference in milliseconds
            long diffInMillis = end.getTime() - start.getTime();

            // Convert to hours
            return diffInMillis / (1000.0 * 60 * 60);
        } catch (ParseException e) {
            return -1;
        }
    }

    /**
     * Calculate price based on hourly rate and duration
     * @param startTime Start time (HH:MM)
     * @param endTime End time (HH:MM)
     * @param hourlyRate Rate per hour
     * @return Total price or -1 if invalid input
     */
    public static double calculatePrice(String startTime, String endTime, double hourlyRate) {
        if (hourlyRate < 0) {
            return -1;
        }

        double durationInHours = calculateDurationInHours(startTime, endTime);
        if (durationInHours < 0) {
            return -1;
        }

        return durationInHours * hourlyRate;
    }
}

