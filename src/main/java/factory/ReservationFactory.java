//package factory;
//
//public class ReservationFactory {
//}
package factory;

/*
factory.ReservationFactory
Reservation Factory class
Author: Avela Bonakali
Date: 20/03/2025
 */

import domain.Reservation;
import domain.Vehicle;
import domain.ParkingSpot;
import domain.User;
import util.Helper;

import java.util.Date;

public class ReservationFactory {

    // creates reservation object with all attributes
    public static Reservation createReservation(String reservationID, String startTime, String endTime,
                                                Date date, double price, Vehicle vehicle,
                                                ParkingSpot parkingSpot, User user) {

        if(Helper.isNullorEmpty(reservationID) ||
                Helper.isNullorEmpty(startTime) ||
                Helper.isNullorEmpty(endTime) ||
                date == null ||
                price < 0 ||
                vehicle == null ||
                parkingSpot == null ||
                user == null) {
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

    // creates reservation without user (for walk-in vehicle reservations)
    public static Reservation createReservation(String reservationID, String startTime, String endTime,
                                                Date date, double price, Vehicle vehicle,
                                                ParkingSpot parkingSpot) {

        if(Helper.isNullorEmpty(reservationID) ||
                Helper.isNullorEmpty(startTime) ||
                Helper.isNullorEmpty(endTime) ||
                date == null ||
                price < 0 ||
                vehicle == null ||
                parkingSpot == null) {
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
                .build();
    }

    // creates reservation without vehicle (for user without a vehicle)
    public static Reservation createReservation(String reservationID, String startTime, String endTime,
                                                Date date, double price,
                                                ParkingSpot parkingSpot, User user) {

        if(Helper.isNullorEmpty(reservationID) ||
                Helper.isNullorEmpty(startTime) ||
                Helper.isNullorEmpty(endTime) ||
                date == null ||
                price < 0 ||
                parkingSpot == null ||
                user == null) {
            return null;
        }

        return new Reservation.Builder()
                .setReservationID(reservationID)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setDate(date)
                .setPrice(price)
                .setParkingSpot(parkingSpot)
                .setUser(user)
                .build();
    }

    // creates basic reservation with just time and parking spot
    public static Reservation createBasicReservation(String reservationID, String startTime, String endTime,
                                                     Date date, ParkingSpot parkingSpot) {

        if(Helper.isNullorEmpty(reservationID) ||
                Helper.isNullorEmpty(startTime) ||
                Helper.isNullorEmpty(endTime) ||
                date == null ||
                parkingSpot == null) {
            return null;
        }

        return new Reservation.Builder()
                .setReservationID(reservationID)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setDate(date)
                .setParkingSpot(parkingSpot)
                .setPrice(0.0) // Default price
                .build();
    }
}