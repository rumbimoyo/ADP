
package factory;

//factory.ReservationFactory
//Reservation Factory class
//Author: Avela Bonakali
//Date: 20/03/2025
// */

import domain.Reservation;
import domain.Vehicle;
import domain.ParkingSpot;
import domain.User;
import util.Helper;
import java.util.Date;

public class ReservationFactory {
    private static final String TIME_REGEX = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
    private static final double DEFAULT_PRICE = 0.0;

    // Main factory method with validation
    private static Reservation create(String reservationID,
                                      String startTime,
                                      String endTime,
                                      Date date,
                                      double price,
                                      Vehicle vehicle,
                                      ParkingSpot parkingSpot,
                                      User user,
                                      boolean requireVehicle,
                                      boolean requireUser) {
        if (!isValid(reservationID, startTime, endTime, date, price, parkingSpot,
                vehicle, requireVehicle, user, requireUser)) {
            return null;
        }

        return new Reservation.Builder()
                .setReservationID(reservationID)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setDate(date)
                .setPrice(price)
                .setVehicle(vehicle)
                .setParkingSpot(parkingSpot)
                .setUser(user)
                .build();
    }

    // Validation logic
    private static boolean isValid(String reservationID,
                                   String startTime,
                                   String endTime,
                                   Date date,
                                   double price,
                                   ParkingSpot parkingSpot,
                                   Vehicle vehicle,
                                   boolean requireVehicle,
                                   User user,
                                   boolean requireUser) {
        return !Helper.isNullorEmpty(reservationID) &&
                isValidTime(startTime) &&
                isValidTime(endTime) &&
                startTime.compareTo(endTime) < 0 &&
                date != null &&
                price >= 0 &&
                parkingSpot != null &&
                (!requireVehicle || vehicle != null) &&
                (!requireUser || user != null);
    }

    private static boolean isValidTime(String time) {
        return time != null && time.matches(TIME_REGEX);
    }

    // Public creation methods
    public static Reservation createFullReservation(String reservationID, String startTime, String endTime,
                                                    Date date, double price, Vehicle vehicle,
                                                    ParkingSpot parkingSpot, User user) {
        return create(reservationID, startTime, endTime, date, price, vehicle, parkingSpot, user, true, true);
    }

    public static Reservation createWalkInReservation(String reservationID, String startTime, String endTime,
                                                      Date date, double price, Vehicle vehicle,
                                                      ParkingSpot parkingSpot) {
        return create(reservationID, startTime, endTime, date, price, vehicle, parkingSpot, null, true, false);
    }

    public static Reservation createUserReservation(String reservationID, String startTime, String endTime,
                                                    Date date, double price,
                                                    ParkingSpot parkingSpot, User user) {
        return create(reservationID, startTime, endTime, date, price, null, parkingSpot, user, false, true);
    }

    public static Reservation createBasicReservation(String reservationID, String startTime, String endTime,
                                                     Date date, ParkingSpot parkingSpot) {
        return create(reservationID, startTime, endTime, date, DEFAULT_PRICE, null, parkingSpot, null, false, false);
    }
}